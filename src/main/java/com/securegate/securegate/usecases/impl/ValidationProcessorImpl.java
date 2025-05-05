package com.securegate.securegate.usecases.impl;

import com.securegate.securegate.domains.*;
import com.securegate.securegate.gateways.QuodNotifierGateway;
import com.securegate.securegate.gateways.repositories.DocumentRepository;
import com.securegate.securegate.gateways.repositories.FacialBiometryRepository;
import com.securegate.securegate.gateways.repositories.FingerprintBiometryRepository;
import com.securegate.securegate.gateways.repositories.ValidationResultRepository;
import com.securegate.securegate.gateways.requests.ValidationRequest;
import com.securegate.securegate.gateways.responses.ValidationResultResponse;
import com.securegate.securegate.usecases.interfaces.ValidationProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ValidationProcessorImpl implements ValidationProcessor {

    private final FacialBiometryRepository facialBiometryRepository;
    private final FingerprintBiometryRepository fingerprintBiometryRepository;
    private final DocumentRepository documentRepository;
    private final ValidationResultRepository validationResultRepository;
    private final QuodNotifierGateway quodNotifierGateway;

    @Override
    public ValidationResultResponse process(ValidationRequest request) {

        validateInput(request);

        boolean isFraud = simulateFraud();
        String fraudReason = isFraud ? getFraudReason() : "Sem indícios de fraude";

        ValidationResult result = new ValidationResult();
        result.setId(toString());
        result.setValid(!isFraud);
        result.setSource(request.getType());
        result.setReason(fraudReason);
        result.setValidatedAt(LocalDateTime.now());

        switch (request.getType().toLowerCase()) {
            case "facial" -> {
                FacialBiometry facial = new FacialBiometry();
                facial.setImagePath(request.getImagePath());
                facial.setFraudDetected(isFraud);
                facial.setMetadata(request.getMetadata());
                facial.setCapturedAt(LocalDateTime.now());
                facialBiometryRepository.save(facial);
            }
            case "fingerprint" -> {
                FingerprintBiometry fingerprint = new FingerprintBiometry();
                fingerprint.setImagePath(request.getImagePath());
                fingerprint.setFraudDetected(isFraud);
                fingerprint.setMetadata(request.getMetadata());
                fingerprint.setCapturedAt(LocalDateTime.now());
                fingerprintBiometryRepository.save(fingerprint);
            }
            case "document" -> {
                DocumentAnalysis doc = new DocumentAnalysis();
                doc.setDocumentType("RG");
                doc.setFrontImagePath(request.getFrontImagePath());
                doc.setBackImagePath(request.getBackImagePath());
                doc.setFraudDetected(isFraud);
                doc.setMetadata(request.getMetadata());
                doc.setCapturedAt(LocalDateTime.now());
                documentRepository.save(doc);
            }
            default -> throw new IllegalArgumentException("Fonte desconhecida: " + request.getType());
        }

        ValidationResult saved = validationResultRepository.save(result);

        if (!saved.isValid()) {
            quodNotifierGateway.notifyFraud(saved);
        }

        return new ValidationResultResponse(
                saved.getId(),
                saved.isValid(),
                saved.getReason(),
                saved.getSource(),
                saved.getValidatedAt()
        );
    }

    private void validateInput(ValidationRequest request) {
        if (request.getType() == null || request.getType().isBlank()) {
            throw new IllegalArgumentException("O tipo de validação é obrigatório.");
        }

        Metadata metadata = request.getMetadata();
        if (metadata == null ||
                metadata.getDevice() == null || metadata.getDevice().isBlank() ||
                metadata.getIp() == null || metadata.getIp().isBlank() ||
                metadata.getTimestamp() == null || metadata.getTimestamp().isBlank()) {

            throw new IllegalArgumentException("Metadados ausentes ou inválidos.");
        }


        if (!"document".equalsIgnoreCase(request.getType())) {
            if (request.getImagePath() == null || !request.getImagePath().endsWith(".jpg")) {
                throw new IllegalArgumentException("Formato de imagem não suportado. Utilize .jpg");
            }
        }
    }

    private boolean simulateFraud() {
        return Math.random() < 0.2;
    }

    private String getFraudReason() {
        String[] motivos = {
                "Deepfake detectado",
                "Uso de máscara artificial",
                "Foto de foto identificada"
        };
        int index = (int) (Math.random() * motivos.length);
        return motivos[index];
    }
}
