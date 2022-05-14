package com.akoca.noteservice.util;

import com.akoca.noteservice.enums.OperationResultCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

import java.time.Instant;
import java.util.Optional;

@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class OperationResult<T> {
    private final T resultData;
    private final OperationResultCode operationResultCode;
    private final Exception operationException;
    private ExecutionTimer executionTimer;

    public Optional<T> getResultData() {
        return Optional.ofNullable(resultData);
    }

    public OperationResultCode getOperationResultCode() {
        return operationResultCode;
    }

    public Optional<Exception> getOperationException() {
        return Optional.ofNullable(operationException);
    }

    public ExecutionTimer getExecutionTimer() {
        return executionTimer;
    }

    public ResponseEntity<String> generateResponseEntity() {
        return ResponseEntity
                .ok(toJsonString());
    }

    public String toJsonString() {
        return JsonUtils.objectToJson(this) //TODO customize json serialization
                .orElseGet(() ->
                        JsonUtils.objectToJson(
                                UnknownErrorResponseDto
                                        .builder()
                                        .desc("Error when doing json conversion")
                                        .timestamp(Instant.now().toEpochMilli())
                                        .build()
                        ).orElse(AppConstants.EMPTY_JSON)
                );
    }

    public static <N> OperationResult<N> unknownErrorOperationResult() {
        return OperationResult
                .<N>builder()
                    .operationResultCode(OperationResultCode.UNKNOWN_ERROR)
                .build();
    }
}
