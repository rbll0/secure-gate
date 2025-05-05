package com.securegate.securegate.usecases.interfaces;

import com.securegate.securegate.domains.DocumentAnalysis;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DocumentService {
    DocumentAnalysis save(DocumentAnalysis data);
    Optional<DocumentAnalysis> findById(String id);
    List<DocumentAnalysis> findAll();
}
