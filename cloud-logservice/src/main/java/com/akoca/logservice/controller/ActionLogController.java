package com.akoca.logservice.controller;

import com.testearser.logservice.model.ActionLog;
import com.testearser.logservice.services.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "/logs")
public class ActionLogController {

    private static final Logger logger = LoggerFactory.getLogger(ActionLogController.class);

    private final LogService logService;

    public ActionLogController (LogService logService) {
        this.logService = logService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ActionLog> logAdd (@Valid @RequestBody ActionLog actionLog){

        ResponseEntity<ActionLog> response = ResponseEntity.created(null)
                .body(logService.saveActionLog(actionLog));

        try {
            TimeUnit.SECONDS.sleep(actionLog.getDelay());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        logger.info("Log add method ended");
        return response;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ActionLog>> getLog() {
        ResponseEntity<List<ActionLog>> response = ResponseEntity.created(URI.create("http://httpbin.org"))
                .body(logService.getActionLog());
        return response;
    }
}
