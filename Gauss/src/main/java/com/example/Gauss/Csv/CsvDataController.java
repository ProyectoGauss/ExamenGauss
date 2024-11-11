package com.example.Gauss.Csv;

import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class CsvDataController {

    @Autowired
    private CsvService csvService;

    @PostMapping("/import-csv")
    public ResponseEntity<String> importCsv(@RequestParam("file") MultipartFile file) {
        try {
            csvService.importCsv(file);
            return ResponseEntity.status(HttpStatus.OK).body("CSV imported successfully");
        } catch (IOException | CsvException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error importing CSV: " + e.getMessage());
        }
    }

    @GetMapping("/csv-data")
    public ResponseEntity<List<CsvData>> getCsvData() {
        List<CsvData> csvDataList = csvService.getAllCsvData();
        return ResponseEntity.ok(csvDataList);
    }
}