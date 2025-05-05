package com.securegate.securegate.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.securegate.securegate.gateways.advices.GlobalExceptionHandler;
import com.securegate.securegate.gateways.controllers.ValidationProcessorController;
import com.securegate.securegate.gateways.requests.ValidationRequest;
import com.securegate.securegate.gateways.responses.ValidationResultResponse;
import com.securegate.securegate.usecases.interfaces.ValidationProcessor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SuppressWarnings("removal")
@WebMvcTest(controllers = ValidationProcessorController.class)
@Import(GlobalExceptionHandler.class)
public class ValidationProcessorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ValidationProcessor validationProcessor;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveRetornarValidacaoComSucesso() throws Exception {
        // Arrange
        ValidationRequest request = new ValidationRequest();
        request.setType("facial");

        ValidationResultResponse response = new ValidationResultResponse(
                UUID.randomUUID().toString(),
                true,
                "Sem indícios de fraude",
                "facial",
                LocalDateTime.now()
        );

        Mockito.when(validationProcessor.process(Mockito.any(ValidationRequest.class)))
                .thenReturn(response);

        // Act & Assert
        mockMvc.perform(post("/api/validate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valid").value(true))
                .andExpect(jsonPath("$.reason").value("Sem indícios de fraude"))
                .andExpect(jsonPath("$.source").value("facial"));
    }

    @Test
    void deveRetornarBadRequestParaTipoInvalido() throws Exception {
        // Arrange
        ValidationRequest request = new ValidationRequest();
        request.setType("invalido");

        Mockito.when(validationProcessor.process(Mockito.any(ValidationRequest.class)))
                .thenThrow(new IllegalArgumentException("Fonte desconhecida: invalido"));

        // Act & Assert
        mockMvc.perform(post("/api/validate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Fonte desconhecida: invalido"));
        ;
        ;
    }
}
