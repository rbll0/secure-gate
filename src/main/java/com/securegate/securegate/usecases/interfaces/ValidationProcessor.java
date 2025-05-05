package com.securegate.securegate.usecases.interfaces;

import com.securegate.securegate.gateways.requests.ValidationRequest;
import com.securegate.securegate.gateways.responses.ValidationResultResponse;


public interface ValidationProcessor {
    ValidationResultResponse process(ValidationRequest request);

}
