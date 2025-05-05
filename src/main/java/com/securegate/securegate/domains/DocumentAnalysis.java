package com.securegate.securegate.domains;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Document(collection = "document_analysis")
public class DocumentAnalysis {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String documentType;
    private String frontImagePath;
    private String backImagePath;
    private boolean isFraudDetected;
    private Metadata metadata;

    private LocalDateTime capturedAt;
}
