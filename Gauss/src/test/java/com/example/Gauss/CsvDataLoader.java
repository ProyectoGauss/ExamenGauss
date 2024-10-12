package com.example.Gauss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.nio.file.Files;

@Component
public class CsvDataLoader implements CommandLineRunner {

    @Autowired
    private CsvDataService csvDataService;

    @Override
    public void run(String... args) throws Exception {
        try {
            ClassPathResource resource = new ClassPathResource("data.csv");
            MultipartFile file = new MockMultipartFile("file", resource.getFilename(), "text/csv", Files.readAllBytes(resource.getFile().toPath()));
            csvDataService.importCsv(file);
            System.out.println("CSV imported successfully");
        } catch (IOException e) {
            System.err.println("Error importing CSV: " + e.getMessage());
        }
    }
}