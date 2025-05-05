package com.securegate.securegate.gateways.controllers;

import com.securegate.securegate.domains.ValidationResult;
import com.securegate.securegate.usecases.impl.ValidationResultServiceImpl;
import com.securegate.securegate.usecases.interfaces.ValidationResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/validation-result")
@RequiredArgsConstructor
public class ValidationResultController {

    private final ValidationResultServiceImpl service;

    @PostMapping
    public ResponseEntity<ValidationResult> criar(@RequestBody ValidationResult validationResult) {
        ValidationResult criado = service.save(validationResult);
        return ResponseEntity.ok(criado);
    }

    @GetMapping
    public ResponseEntity<List<ValidationResult>> listarTodos() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ValidationResult> buscarPorId(@PathVariable String id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
