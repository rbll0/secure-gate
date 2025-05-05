package com.securegate.securegate.usecases.impl;

import com.securegate.securegate.domains.ValidationResult;
import com.securegate.securegate.gateways.QuodNotifierGateway;
import com.securegate.securegate.gateways.repositories.ValidationResultRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ValidationResultServiceImplTest {

    private ValidationResultRepository repository;
    private QuodNotifierGateway quodNotifierGateway;
    private ValidationResultServiceImpl service;

    @BeforeEach
    void setUp() {
        repository = mock(ValidationResultRepository.class);
        quodNotifierGateway = mock(QuodNotifierGateway.class);
        service = new ValidationResultServiceImpl(quodNotifierGateway, repository);
    }

    @Test
    void shouldSaveValidationResultAndNotifyIfInvalid() {
        ValidationResult input = new ValidationResult();
        input.setValid(false);
        input.setReason("Simulação");
        input.setSource("facial");

        ValidationResult saved = new ValidationResult();
        saved.setId(toString());
        saved.setValid(false);
        saved.setReason("Simulação");
        saved.setSource("facial");
        saved.setValidatedAt(LocalDateTime.now());

        when(repository.save(any())).thenReturn(saved);

        ValidationResult result = service.save(input);

        assertNotNull(result.getValidatedAt());
        verify(repository).save(any());
        verify(quodNotifierGateway).notifyFraud(any());
    }

    @Test
    void shouldSaveValidationResultAndNotNotifyIfValid() {
        ValidationResult input = new ValidationResult();
        input.setValid(true);
        input.setReason("OK");
        input.setSource("document");

        when(repository.save(any())).thenReturn(input);

        ValidationResult result = service.save(input);

        assertNotNull(result.getValidatedAt());
        verify(repository).save(any());
        verify(quodNotifierGateway, never()).notifyFraud(any());
    }

    @Test
    void shouldFindById() {
        UUID id = UUID.randomUUID();
        ValidationResult mockResult = new ValidationResult();
        mockResult.setId(id.toString());
        when(repository.findById(id.toString())).thenReturn(Optional.of(mockResult));

        Optional<ValidationResult> result = service.findById(id.toString());

        assertTrue(result.isPresent());
        assertEquals(id, result.get().getId());
    }

    @Test
    void shouldReturnAllResults() {
        List<ValidationResult> list = List.of(new ValidationResult(), new ValidationResult());
        when(repository.findAll()).thenReturn(list);

        List<ValidationResult> results = service.findAll();

        assertEquals(2, results.size());
    }
}
