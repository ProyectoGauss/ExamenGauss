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
public class CsvDataLoader {

    @Autowired
    private CsvRepository csvRepository;

    public void importCsv(MultipartFile file) throws IOException, CsvException {
        //borra todos los datos de la tabla antes de importar nuevos datos
        csvRepository.deleteAll();

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8));
             CSVReader csvReader = new CSVReader(fileReader)) {

            List<String[]> records = csvReader.readAll();
            String[] header = records.get(0);
            records.remove(0);

            for (String[] record : records) {
                CsvData csvData = new CsvData();
                csvData.setId(Long.parseLong(record[0]));
                csvData.setEdad(Double.parseDouble(record[1]));
                csvData.setAltura(Double.parseDouble(record[2]));
                csvData.setPeso(Double.parseDouble(record[3]));
                csvData.setNota(Double.parseDouble(record[4]));
                csvData.setGenero(record[5]);

                csvRepository.save(csvData);
            }
        }
    }
}