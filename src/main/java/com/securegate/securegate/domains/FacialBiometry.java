package com.securegate.securegate.domains;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "facial_biometry")
public class FacialBiometry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String imagePath;
    private boolean isFraudDetected;
    private Metadata metadata;

    private LocalDateTime capturedAt;
}
