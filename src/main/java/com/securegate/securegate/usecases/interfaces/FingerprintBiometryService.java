package com.securegate.securegate.usecases.interfaces;

import com.securegate.securegate.domains.FingerprintBiometry;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FingerprintBiometryService {
    FingerprintBiometry save(FingerprintBiometry data);
    Optional<FingerprintBiometry> findById(String id);
    List<FingerprintBiometry> findAll();
}
