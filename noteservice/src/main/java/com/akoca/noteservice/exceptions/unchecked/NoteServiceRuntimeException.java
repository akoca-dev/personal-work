package com.akoca.noteservice.exceptions.unchecked;

import com.akoca.noteservice.enums.OperationResultCode;

import java.time.Instant;

public class NoteServiceRuntimeException extends BaseRuntimeException {
    public NoteServiceRuntimeException(String message, OperationResultCode operationResultCode, Instant exceptionTime) {
        super(message, operationResultCode, exceptionTime);
    }

    public NoteServiceRuntimeException(String message, Throwable cause, OperationResultCode operationResultCode, Instant exceptionTime) {
        super(message, cause, operationResultCode, exceptionTime);
    }
}
