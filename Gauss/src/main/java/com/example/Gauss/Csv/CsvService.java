package com.example.Gauss.Csv;

import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@Service
public class CsvService {

    @Autowired
    private CsvDataLoader csvDataLoader;

    @Autowired
    private CsvRepository csvRepository;

    public void importCsv(MultipartFile file) throws IOException, CsvException {
        csvDataLoader.importCsv(file);
    }

    public List<CsvData> getAllCsvData() {
        return csvRepository.findAll();
    }
}
