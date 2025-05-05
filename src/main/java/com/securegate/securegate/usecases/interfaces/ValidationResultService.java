package com.securegate.securegate.usecases.interfaces;

import com.securegate.securegate.domains.ValidationResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ValidationResultService {
    ValidationResult save(ValidationResult result);
    Optional<ValidationResult> findById(String id);
    List<ValidationResult> findAll();
}
