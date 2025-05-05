package com.securegate.securegate.usecases.impl;

import com.securegate.securegate.domains.FacialBiometry;
import com.securegate.securegate.gateways.repositories.FacialBiometryRepository;
import com.securegate.securegate.usecases.interfaces.FacialBiometryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("facialBiometryServiceImpl")
@RequiredArgsConstructor
public class FacialBiometryServiceImpl implements FacialBiometryService {

    private final FacialBiometryRepository repository;

    @Override
    public FacialBiometry save(FacialBiometry data) {
        return repository.save(data);
    }

    @Override
    public Optional<FacialBiometry> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<FacialBiometry> findAll() {
        return repository.findAll();
    }
}
