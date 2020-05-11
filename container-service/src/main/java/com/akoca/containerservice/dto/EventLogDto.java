package com.akoca.containerservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
public class EventLogDto {

    private Long id;
    private String serviceName;
    private Integer servicePort;
    private Instant logTime;
}