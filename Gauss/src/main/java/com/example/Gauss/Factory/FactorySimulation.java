package com.example.Gauss.Factory;

import com.example.Gauss.Controller.VisualizationController;
import com.example.Gauss.Csv.CsvData;
import com.example.Gauss.Csv.CsvRepository;
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
    private CsvRepository csvRepository;

    @Autowired
    private ComponentProducer componentProducer;

    @Autowired
    private VisualizationController visualizationController;

    public void startSimulation() {
        List<CsvData> csvDataList = csvRepository.findAll();

        for (CsvData data : csvDataList) {
            String componentName = "Component from CSV: " + data.getId();
            try {
                componentProducer.produceComponent(componentName, componentName);
                logger.info("Produced component: {}", componentName);
            } catch (Exception e) {
                logger.error("Failed to produce component: {}", componentName, e);
            }
        }
        logger.info("Factory simulation completed.");
        visualizationController.sendUpdate("Factory simulation completed.");
    }
}