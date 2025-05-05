package com.securegate.securegate.gateways.requests;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FacialBiometryRequest {
    private String imagePath;
    private boolean fraudDetected;
    private String metadata;
    private LocalDateTime capturedAt;
}
