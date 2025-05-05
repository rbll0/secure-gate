package com.securegate.securegate.gateways.controllers;

import com.securegate.securegate.domains.FacialBiometry;
import com.securegate.securegate.usecases.impl.FacialBiometryServiceImpl;
import com.securegate.securegate.usecases.interfaces.FacialBiometryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/biometria-facial")
@RequiredArgsConstructor
public class BiometriaFacialController {

    private final FacialBiometryService facialBiometryService;

    @PostMapping
    public ResponseEntity<FacialBiometry> criar(@RequestBody FacialBiometry facialBiometry) {
        FacialBiometry criada = facialBiometryService.save(facialBiometry);
        return ResponseEntity.ok(criada);
    }

    @GetMapping
    public ResponseEntity<List<FacialBiometry>> listarTodas() {
        return ResponseEntity.ok(facialBiometryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacialBiometry> buscarPorId(@PathVariable String id) {
        return facialBiometryService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
