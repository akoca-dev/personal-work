package com.akoca.userservice.exceptions.unchecked;

import com.akoca.userservice.enums.OperationResultCode;

import java.time.Instant;

public class UserServiceRuntimeException extends BaseRuntimeException {
    public UserServiceRuntimeException(String message, OperationResultCode operationResultCode, Instant exceptionTime) {
        super(message, operationResultCode, exceptionTime);
    }

    public UserServiceRuntimeException(String message, Throwable cause, OperationResultCode operationResultCode, Instant exceptionTime) {
        super(message, cause, operationResultCode, exceptionTime);
    }
}
