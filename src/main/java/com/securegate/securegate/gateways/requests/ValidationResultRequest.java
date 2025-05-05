package com.securegate.securegate.gateways.requests;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ValidationResultRequest {
    private boolean isValid;
    private String reason;
    private String source; // e.g., "facial", "fingerprint", "document"
    private LocalDateTime validatedAt;
}
