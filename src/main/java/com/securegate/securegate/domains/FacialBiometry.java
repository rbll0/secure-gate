package com.securegate.securegate.domains;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "facial_biometry")
public class FacialBiometry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String imagePath;
    private boolean isFraudDetected;
    private String metadata;

    private LocalDateTime capturedAt;
}
