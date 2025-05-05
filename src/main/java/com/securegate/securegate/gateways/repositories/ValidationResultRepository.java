package com.securegate.securegate.gateways.repositories;

import com.securegate.securegate.domains.ValidationResult;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ValidationResultRepository extends MongoRepository<ValidationResult, String> {
}
