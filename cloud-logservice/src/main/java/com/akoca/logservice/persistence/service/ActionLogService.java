package com.akoca.logservice.persistence.service;

import com.akoca.logservice.model.ActionLog;
import com.akoca.logservice.persistence.ActionLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionLogService {

    @Autowired
    private ActionLogRepository actionLogRepository;

    public void saveActionLog(ActionLog actionLog) {
        actionLogRepository.save(actionLog);
    }

    public List<ActionLog> getActionLog() {
        return (List<ActionLog>) actionLogRepository.findAll();
    }
}
