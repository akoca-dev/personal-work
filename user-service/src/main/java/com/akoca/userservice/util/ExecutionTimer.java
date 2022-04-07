package com.akoca.userservice.util;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.Instant;

@Getter
@Setter
public final class ExecutionTimer {
    private Instant startTime;
    private Instant endTime;

    public boolean isTimerStarted() {
        return startTime != null;
    }

    public boolean isTimerEnded() {
        return endTime != null;
    }

    public ExecutionTimer startTimer() {
        setStartTime(Instant.now());
        return this;
    }

    public ExecutionTimer stopTimer() {
        setEndTime(Instant.now());
        return this;
    }

    public Duration getExecutionDuration() {
        return Duration.between(getStartTime(), getEndTime());
    }

    public static ExecutionTimer getStartedInstance() {
        return new ExecutionTimer().startTimer();
    }
}
