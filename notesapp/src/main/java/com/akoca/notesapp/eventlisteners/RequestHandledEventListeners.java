package com.akoca.notesapp.eventlisteners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.RequestHandledEvent;
import org.springframework.web.context.support.ServletRequestHandledEvent;

@Slf4j
@Component
public class RequestHandledEventListeners {

    @EventListener
    public void handleRequestHandledEvent(RequestHandledEvent requestHandledEvent) {
        if(requestHandledEvent instanceof ServletRequestHandledEvent) {
            log.info("Servlet request handled: {}", requestHandledEvent.getDescription());
        } else {
            log.info("Non-servlet request handled: {}", requestHandledEvent.getDescription());
        }
    }
}