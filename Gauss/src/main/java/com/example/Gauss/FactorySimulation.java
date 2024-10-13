package com.example.Gauss;

import com.example.Gauss.Csv.CsvData;
import com.example.Gauss.Csv.CsvDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

@Service
public class FactorySimulation {

    @Autowired
    private CsvDataRepository csvDataRepository;

    public void startSimulation() {
        List<CsvData> csvDataList = csvDataRepository.findAll();
        BlockingQueue<Component> buffer = new LinkedBlockingQueue<>(10);
        Semaphore semaphore = new Semaphore(1);

        for (CsvData data : csvDataList) {
            WorkStation station = new WorkStation(buffer, "Component from CSV: " + data.getId(), semaphore);
            station.start();
        }

        AssemblyLine assemblyLine = new AssemblyLine(buffer, semaphore);
        assemblyLine.start();
    }
}