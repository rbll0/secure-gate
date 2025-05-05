package com.securegate.securegate.gateways;

import com.securegate.securegate.domains.ValidationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class QuodNotifierGateway {
    private static final Logger logger = LoggerFactory.getLogger(QuodNotifierGateway.class);

    public void notifyFraud(ValidationResult result) {
        // Simula envio de notificação para a QUOD
        logger.warn("[QUOD NOTIFICATION] Possible fraud detected:");
        logger.warn("Validation ID: {}", result.getId());
        logger.warn("Type: {}", result.getSource());
        logger.warn("Message: {}", result.getReason());

        // Aqui você poderia fazer um HTTP POST para o sistema da QUOD se fosse real
        // Exemplo (simulado): httpClient.post("https://quod.internal/api/alerts", result);
    }
}

