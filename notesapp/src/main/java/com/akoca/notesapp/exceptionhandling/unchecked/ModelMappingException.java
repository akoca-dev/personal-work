package com.akoca.notesapp.exceptionhandling.unchecked;

import com.akoca.notesapp.exceptionhandling.BaseUncheckedException;

import java.time.Instant;

public class ModelMappingException extends BaseUncheckedException {
    private final Class<?> from;
    private final Class<?> to;

    public ModelMappingException(Instant exceptionTime, Class<?> from, Class<?> to) {
        super(exceptionTime);
        this.from = from;
        this.to = to;
    }

    public ModelMappingException(String message, Instant exceptionTime, Class<?> from, Class<?> to) {
        super(message, exceptionTime);
        this.from = from;
        this.to = to;
    }

    public ModelMappingException(String message, Throwable cause, Instant exceptionTime, Class<?> from, Class<?> to) {
        super(message, cause, exceptionTime);
        this.from = from;
        this.to = to;
    }

    public Class<?> getFrom() {
        return from;
    }

    public Class<?> getTo() {
        return to;
    }
}