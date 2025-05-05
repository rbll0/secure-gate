package com.securegate.securegate.usecases.impl;

import com.securegate.securegate.domains.FingerprintBiometry;
import com.securegate.securegate.gateways.repositories.FingerprintBiometryRepository;
import com.securegate.securegate.usecases.interfaces.FingerprintBiometryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FingerprintBiometryServiceImpl implements FingerprintBiometryService {

    private final FingerprintBiometryRepository repository;

    @Override
    public FingerprintBiometry save(FingerprintBiometry data) {
        return repository.save(data);
    }

    @Override
    public Optional<FingerprintBiometry> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<FingerprintBiometry> findAll() {
        return repository.findAll();
    }
}