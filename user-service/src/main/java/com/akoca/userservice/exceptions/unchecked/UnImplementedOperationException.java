package com.akoca.userservice.exceptions.unchecked;

import com.akoca.userservice.enums.OperationResultCode;

import java.time.Instant;

public class UnImplementedOperationException extends BaseRuntimeException {
    private final String operationName;

    public UnImplementedOperationException(String message, OperationResultCode operationResultCode, Instant exceptionTime, String operationName) {
        super(message, operationResultCode, exceptionTime);
        this.operationName = operationName;
    }

    public UnImplementedOperationException(String message, Throwable cause, OperationResultCode operationResultCode, Instant exceptionTime, String operationName) {
        super(message, cause, operationResultCode, exceptionTime);
        this.operationName = operationName;
    }

    public String getOperationName() {
        return operationName;
    }
}
