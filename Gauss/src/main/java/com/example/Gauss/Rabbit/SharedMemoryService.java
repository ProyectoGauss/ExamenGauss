package com.example.Gauss.Rabbit;

import com.example.Gauss.Csv.CsvData;
import com.example.Gauss.Csv.CsvRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SharedMemoryService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private CsvRepository csvRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void writeToSharedMemory(String data) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.COMPONENT_QUEUE, data);
    }

    @RabbitListener(queues = RabbitMQConfig.COMPONENT_QUEUE)
    public void readFromSharedMemory(String data) {
        System.out.println("Read from shared memory: " + data);
        // Process the data
        processData(data);
    }

    private void processData(String data) {
        try {
            // Parse the data (assuming it's in JSON format)
            CsvData csvData = objectMapper.readValue(data, CsvData.class);

            // Retrieve all CSV data from the repository
            List<CsvData> allData = csvRepository.findAll();

            // Calculate the mean and standard deviation
            double mean = allData.stream().collect(Collectors.averagingDouble(CsvData::getNota));
            double variance = allData.stream().mapToDouble(d -> Math.pow(d.getNota() - mean, 2)).sum() / allData.size();
            double stdDev = Math.sqrt(variance);

            // Apply the Gaussian function to the data
            double gaussValue = (1 / (stdDev * Math.sqrt(2 * Math.PI))) * Math.exp(-Math.pow(csvData.getNota() - mean, 2) / (2 * Math.pow(stdDev, 2)));

            // Example operation: update the nota field with the Gaussian value
            csvData.setNota(gaussValue);

            // Save the processed data to the database
            csvRepository.save(csvData);

            System.out.println("Processed and saved data: " + csvData);
        } catch (IOException e) {
            System.err.println("Error processing data: " + e.getMessage());
        }
    }
}
