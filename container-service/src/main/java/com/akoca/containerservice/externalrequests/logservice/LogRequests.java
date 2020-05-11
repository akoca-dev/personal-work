package com.akoca.containerservice.externalrequests.logservice;

import com.akoca.containerservice.dto.EventLogDto;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.retry.annotation.CircuitBreaker;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.time.Instant;
import java.util.Objects;

@NoArgsConstructor
@RequiredArgsConstructor
@Component
public class LogRequests {

    private final WebClient.Builder loadBalancedWebClientBuilder;

    private Integer servicePort;
    private String serviceName;

    @CircuitBreaker(maxAttempts = 3 , openTimeout = 4000L)
    private void sendActivityLog(Long id, Instant logTime) {
        EventLogDto newEventLogDto = new EventLogDto();
        newEventLogDto.setId(id);
        newEventLogDto.setLogTime(logTime);
        newEventLogDto.

        ActionLog actionLog = new ActionLog();
        actionLog.setDelay(delay);
        actionLog.setRequestServiceName("CONTAINER-SERVICE");
        actionLog.setRequestServicePort(Integer.valueOf(Objects.requireNonNull(environment.getProperty("server.port"))));

        ClientResponse clientResponse = loadBalancedWebClientBuilder
                .build()
                .post()
                .uri(URI.create("lb://log-service/log/logadd"))
                .body(BodyInserters.fromValue(actionLog))
                .exchange()
                .block();

        if(null != clientResponse) {
            logger.info("Log Sent From Device Service.Response Status: {}" , clientResponse.statusCode());
        }

        logger.info("Send Activity Finished");
    }
}