package com.example.Gauss.Csv;

import com.example.Gauss.Controller.VisualizationController;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CsvDataLoader {

    private static final Logger logger = LoggerFactory.getLogger(CsvDataLoader.class);

    @Autowired
    private CsvRepository csvRepository;

    @Autowired
    private VisualizationController visualizationController;

    public void importCsv(MultipartFile file) throws IOException, CsvException {
        csvRepository.deleteAll();

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8));
             CSVReader csvReader = new CSVReader(fileReader)) {

            List<String[]> records = csvReader.readAll();
            String[] header = records.get(0);
            records.remove(0);

            for (String[] record : records) {
                CsvData csvData = new CsvData();
                csvData.setId(record[0]);
                csvData.setEdad((int) Double.parseDouble(record[1]));
                csvData.setAltura(Double.parseDouble(record[2]));
                csvData.setPeso(Double.parseDouble(record[3]));
                csvData.setNota(Double.parseDouble(record[4]));
                csvData.setGenero(record[5]);

                csvRepository.save(csvData);
            }
        }
        logger.info("CSV data import completed.");
        visualizationController.sendUpdate("CSV data import completed.");
    }
}