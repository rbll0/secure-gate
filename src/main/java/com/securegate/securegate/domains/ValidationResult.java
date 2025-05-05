package com.securegate.securegate.domains;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Document(collection = "validation_result")
public class ValidationResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private boolean isValid;
    private String reason;
    private String source; // e.g., "facial", "fingerprint", "document"

    private LocalDateTime validatedAt;
}
