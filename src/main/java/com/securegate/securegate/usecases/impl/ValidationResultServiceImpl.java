package com.securegate.securegate.usecases.impl;

import com.securegate.securegate.domains.ValidationResult;
import com.securegate.securegate.gateways.QuodNotifierGateway;
import com.securegate.securegate.gateways.repositories.ValidationResultRepository;
import com.securegate.securegate.usecases.interfaces.ValidationResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ValidationResultServiceImpl implements ValidationResultService {

    private final QuodNotifierGateway quodNotifierGateway;
    private final ValidationResultRepository repository;

    @Override
    public ValidationResult save(ValidationResult result) {
        result.setValidatedAt(LocalDateTime.now());
        ValidationResult savedResult = repository.save(result);

        if (!result.isValid()) {
            quodNotifierGateway.notifyFraud(savedResult);
        }

        return savedResult;
    }

    @Override
    public Optional<ValidationResult> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<ValidationResult> findAll() {
        return repository.findAll();
    }
}
