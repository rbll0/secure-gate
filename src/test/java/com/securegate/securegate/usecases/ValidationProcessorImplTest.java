package com.securegate.securegate.usecases;

import com.securegate.securegate.domains.FacialBiometry;
import com.securegate.securegate.domains.ValidationResult;
import com.securegate.securegate.gateways.QuodNotifierGateway;
import com.securegate.securegate.gateways.repositories.*;
import com.securegate.securegate.gateways.requests.ValidationRequest;
import com.securegate.securegate.gateways.responses.ValidationResultResponse;
import com.securegate.securegate.usecases.impl.ValidationProcessorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class ValidationProcessorImplTest {

    @Mock private FacialBiometryRepository facialBiometryRepository;
    @Mock private FingerprintBiometryRepository fingerprintBiometryRepository;
    @Mock private DocumentRepository documentRepository;
    @Mock private ValidationResultRepository validationResultRepository;
    @Mock private QuodNotifierGateway quodNotifierGateway;

    @InjectMocks private ValidationProcessorImpl processor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProcessFacialBiometry() {
        ValidationRequest request = new ValidationRequest();
        request.setType("facial");

        ValidationResult result = new ValidationResult();
        result.setId(toString());
        result.setSource("facial");
        result.setValid(true);
        result.setReason("Sem indícios de fraude");
        result.setValidatedAt(LocalDateTime.now());

        when(validationResultRepository.save(any(ValidationResult.class))).thenReturn(result);

        ValidationResultResponse response = processor.process(request);

        assertThat(response).isNotNull();
        assertThat(response.getSource()).isEqualTo("facial");
        verify(facialBiometryRepository, times(1)).save(any(FacialBiometry.class));
    }

    @Test
    void testProcessInvalidType() {
        ValidationRequest request = new ValidationRequest();
        request.setType("invalido");

        try {
            processor.process(request);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).contains("Fonte desconhecida");
        }
    }
}
