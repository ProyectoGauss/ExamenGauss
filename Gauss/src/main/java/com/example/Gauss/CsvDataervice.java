package com.example.Gauss;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Service
public class CsvDataervice {

    @Autowired
    private CsvDataRepository csvDataRepository;

    public void importCsv(MultipartFile file) throws IOException {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {

            for (CSVRecord csvRecord : csvParser) {
                CsvData csvData = new CsvData();
                csvData.setColumn1(csvRecord.get("edad"));
                csvData.setColumn2(csvRecord.get("altura"));
                csvData.setColumn3(csvRecord.get("peso"));
                csvData.setColumn4(csvRecord.get("nota"));
                csvData.setColumn5(csvRecord.get("genero"));


                csvDataRepository.save(csvData);
            }
        }
    }
}