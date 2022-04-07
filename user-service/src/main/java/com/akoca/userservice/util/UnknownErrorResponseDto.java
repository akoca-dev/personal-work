package com.akoca.userservice.util;

import lombok.Builder;

@Builder
public class UnknownErrorResponseDto {

    private final String desc;
    private final long timestamp;

    public String getDesc() {
        return desc;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
