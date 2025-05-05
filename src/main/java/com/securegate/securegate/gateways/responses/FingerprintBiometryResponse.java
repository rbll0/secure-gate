package com.securegate.securegate.gateways.responses;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class FingerprintBiometryResponse {
    private UUID id;
    private String imagePath;
    private boolean isFraudDetected;
    private String metadata;
    private LocalDateTime capturedAt;
}
