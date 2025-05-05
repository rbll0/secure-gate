package com.securegate.securegate.gateways.responses;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class DocumentAnalysisResponse {
    private UUID id;
    private String documentType;
    private String frontImagePath;
    private String backImagePath;
    private boolean isFraudDetected;
    private String metadata;
    private LocalDateTime capturedAt;
}
