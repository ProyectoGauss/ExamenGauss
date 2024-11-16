package com.example.Gauss.Csv;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CsvRepository extends MongoRepository<CsvData, String> {
}
