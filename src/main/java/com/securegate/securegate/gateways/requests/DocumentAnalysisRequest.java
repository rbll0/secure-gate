package com.securegate.securegate.gateways.requests;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DocumentAnalysisRequest {
    private String documentType;
    private String frontImagePath;
    private String backImagePath;
    private boolean fraudDetected;
    private String metadata;
    private LocalDateTime capturedAt;
}
