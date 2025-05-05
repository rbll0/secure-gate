package com.securegate.securegate.gateways.controllers;

import com.securegate.securegate.domains.DocumentAnalysis;
import com.securegate.securegate.usecases.impl.DocumentServiceImpl;
import com.securegate.securegate.usecases.interfaces.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping
    public ResponseEntity<DocumentAnalysis> criar(@RequestBody DocumentAnalysis documentAnalysis) {
        DocumentAnalysis criado = documentService.save(documentAnalysis);
        return ResponseEntity.ok(criado);
    }

    @GetMapping
    public ResponseEntity<List<DocumentAnalysis>> listarTodos() {
        return ResponseEntity.ok(documentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentAnalysis> buscarPorId(@PathVariable String id) {
        return documentService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
