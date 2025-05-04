package com.securegate.securegate.domains;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "document_analysis")
public class DocumentAnalysis {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String documentType;
    private String frontImagePath;
    private String backImagePath;
    private boolean isFraudDetected;
    private String metadata;

    private LocalDateTime capturedAt;
}
