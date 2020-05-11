package com.akoca.notesapp.exceptionhandling;

import java.time.Instant;

public abstract class BaseCheckedException extends Exception implements CustomizedThrowable {
    private final Instant exceptionTime;

    public BaseCheckedException(Instant exceptionTime) {
        this.exceptionTime = exceptionTime;
    }

    public BaseCheckedException(String message, Instant exceptionTime) {
        super(message);
        this.exceptionTime = exceptionTime;
    }

    public BaseCheckedException(String message, Throwable cause, Instant exceptionTime) {
        super(message, cause);
        this.exceptionTime = exceptionTime;
    }

    @Override
    public Instant getExceptionTime() {
        return exceptionTime;
    }
}
