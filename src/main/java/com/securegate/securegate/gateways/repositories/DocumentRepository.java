package com.securegate.securegate.gateways.repositories;

import com.securegate.securegate.domains.DocumentAnalysis;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository  extends MongoRepository<DocumentAnalysis, String> {
}
