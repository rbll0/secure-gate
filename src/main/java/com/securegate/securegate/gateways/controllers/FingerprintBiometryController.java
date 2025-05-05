package com.securegate.securegate.gateways.controllers;

import com.securegate.securegate.domains.FingerprintBiometry;
import com.securegate.securegate.usecases.impl.FingerprintBiometryServiceImpl;
import com.securegate.securegate.usecases.interfaces.FingerprintBiometryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fingerprint-biometry")
@RequiredArgsConstructor
public class FingerprintBiometryController {
    private final FingerprintBiometryService fingerprintBiometryService;

    @PostMapping
    public ResponseEntity<FingerprintBiometry> criar(@RequestBody FingerprintBiometry fingerprintBiometry) {
        FingerprintBiometry criada = fingerprintBiometryService.save(fingerprintBiometry);
        return ResponseEntity.ok(criada);
    }

    @GetMapping
    public ResponseEntity<List<FingerprintBiometry>> listarTodas() {
        return ResponseEntity.ok(fingerprintBiometryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FingerprintBiometry> buscarPorId(@PathVariable String id) {
        return fingerprintBiometryService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
