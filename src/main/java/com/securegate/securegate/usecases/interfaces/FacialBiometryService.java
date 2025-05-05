package com.securegate.securegate.usecases.interfaces;

import com.securegate.securegate.domains.FacialBiometry;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FacialBiometryService {
    FacialBiometry save(FacialBiometry data);
    Optional<FacialBiometry> findById(String id);
    List<FacialBiometry> findAll();
}
