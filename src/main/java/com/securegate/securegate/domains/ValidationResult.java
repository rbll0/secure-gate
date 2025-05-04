package com.securegate.securegate.domains;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "validation_result")
public class ValidationResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private boolean isValid;
    private String reason;
    private String source; // e.g., "facial", "fingerprint", "document"

    private LocalDateTime validatedAt;
}
