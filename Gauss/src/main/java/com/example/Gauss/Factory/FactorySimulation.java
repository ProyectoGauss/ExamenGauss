package com.example.Gauss.Factory;

import com.example.Gauss.Csv.CsvData;
import com.example.Gauss.Csv.CsvDataRepository;
import com.example.Gauss.Factory.Component.ComponentProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class FactorySimulation {
    private static final Logger logger = LoggerFactory.getLogger(FactorySimulation.class);

    @Autowired
    private CsvDataRepository csvDataRepository;

    @Autowired
    private ComponentProducer componentProducer;

    /**
     * This method is used to start the simulation of the factory.
     * It reads data from the CSV repository and produces components.
     */
    public void startSimulation() {
        List<CsvData> csvDataList = csvDataRepository.findAll();

        for (CsvData data : csvDataList) {
            String componentName = "Component from CSV: " + data.getId();
            try {
                componentProducer.produceComponent(componentName);
                logger.info("Produced component: {}", componentName);
            } catch (Exception e) {
                logger.error("Failed to produce component: {}", componentName, e);
            }
        }
    }
}