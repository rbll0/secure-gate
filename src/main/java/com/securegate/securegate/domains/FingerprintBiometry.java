package com.securegate.securegate.domains;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Document(collection = "fingerprint_biometry")
public class FingerprintBiometry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String imagePath;
    private boolean isFraudDetected;
    private Metadata metadata;

    private LocalDateTime capturedAt;
}

