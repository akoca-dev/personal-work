package com.akoca.notesapp.exceptionhandling;

import java.time.Instant;

public abstract class BaseUncheckedException extends RuntimeException implements CustomizedThrowable {
    private final Instant exceptionTime;

    public BaseUncheckedException(Instant exceptionTime) {
        this.exceptionTime = exceptionTime;
    }

    public BaseUncheckedException(String message, Instant exceptionTime) {
        super(message);
        this.exceptionTime = exceptionTime;
    }

    public BaseUncheckedException(String message, Throwable cause, Instant exceptionTime) {
        super(message, cause);
        this.exceptionTime = exceptionTime;
    }

    @Override
    public Instant getExceptionTime() {
        return exceptionTime;
    }
}
