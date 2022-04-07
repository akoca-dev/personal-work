package com.akoca.userservice.exceptions.unchecked;

import com.akoca.userservice.enums.OperationResultCode;
import lombok.Getter;

import java.time.Instant;

@Getter
public class BaseRuntimeException extends RuntimeException {
    private final OperationResultCode operationResultCode;
    private final Instant exceptionTime;

    public BaseRuntimeException(String message, OperationResultCode operationResultCode, Instant exceptionTime) {
        super(message);
        this.operationResultCode = operationResultCode;
        this.exceptionTime = exceptionTime;
    }

    public BaseRuntimeException(String message, Throwable cause, OperationResultCode operationResultCode, Instant exceptionTime) {
        super(message, cause);
        this.operationResultCode = operationResultCode;
        this.exceptionTime = exceptionTime;
    }
}
