package com.securegate.securegate.usecases.impl;

import com.securegate.securegate.domains.DocumentAnalysis;
import com.securegate.securegate.gateways.repositories.DocumentRepository;
import com.securegate.securegate.usecases.interfaces.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository repository;

    @Override
    public DocumentAnalysis save(DocumentAnalysis data) {
        return repository.save(data);
    }

    @Override
    public Optional<DocumentAnalysis> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<DocumentAnalysis> findAll() {
        return repository.findAll();
    }
}
