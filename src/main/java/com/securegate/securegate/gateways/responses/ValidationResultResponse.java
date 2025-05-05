package com.securegate.securegate.gateways.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ValidationResultResponse {
    private String id;
    private boolean isValid;
    private String reason;
    private String source; // e.g., "facial", "fingerprint", "document"
    private LocalDateTime validatedAt;
}
