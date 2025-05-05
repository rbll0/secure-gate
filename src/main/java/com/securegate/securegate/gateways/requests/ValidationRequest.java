package com.securegate.securegate.gateways.requests;

import com.securegate.securegate.domains.Metadata;
import lombok.Data;

@Data
public class ValidationRequest {

    private String type; // "facial", "fingerprint", "document"

    // Dados opcionais conforme o tipo
    private String imagePath;
    private String frontImagePath;
    private String backImagePath;
    private Metadata metadata;

}
