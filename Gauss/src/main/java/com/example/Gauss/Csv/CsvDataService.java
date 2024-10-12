package com.example.Gauss.Csv;

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

@Service
public class CsvDataService {

    @Autowired
    private CsvDataRepository csvDataRepository;

    public void importCsv(MultipartFile file) throws IOException, CsvException {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8));
             CSVReader csvReader = new CSVReader(fileReader)) {

            List<String[]> records = csvReader.readAll();
            String[] header = records.get(0);
            records.remove(0);

            for (String[] record : records) {
                CsvData csvData = new CsvData();
                csvData.setEdad(Double.parseDouble(record[0]));
                csvData.setAltura(Double.parseDouble(record[1]));
                csvData.setPeso(Double.parseDouble(record[2]));
                csvData.setNota(Double.parseDouble(record[3]));
                csvData.setGenero(record[4]);


                csvDataRepository.save(csvData);
            }
        }
    }

    public List<CsvData> getAllCsvData() {
        return csvDataRepository.findAll();
    }
}