package com.securegate.securegate.gateways.controllers;

import com.securegate.securegate.gateways.requests.ValidationRequest;
import com.securegate.securegate.gateways.responses.ValidationResultResponse;
import com.securegate.securegate.usecases.interfaces.ValidationProcessor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/validate")
@RequiredArgsConstructor
@Tag(name = "Validação Central", description = "Valida biometria facial, digital ou documento")
public class ValidationProcessorController {

    private final ValidationProcessor validationProcessor;

    @PostMapping
    @Operation(
            summary = "Valida biometria ou documento",
            description = "Recebe uma requisição com dados de biometria ou documento, processa e retorna o resultado da validação"
    )
    public ResponseEntity<ValidationResultResponse> processar(@RequestBody ValidationRequest request) {
        ValidationResultResponse response = validationProcessor.process(request);
        return ResponseEntity.ok(response);
    }
}
