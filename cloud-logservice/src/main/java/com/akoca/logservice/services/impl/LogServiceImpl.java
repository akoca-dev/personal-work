package com.akoca.logservice.services.impl;

import com.akoca.logservice.model.ActionLog;
import com.akoca.logservice.persistence.service.ActionLogService;
import com.akoca.logservice.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    ActionLogService actionLogService;

    @Autowired
    public LogServiceImpl (ActionLogService actionLogService) {
        this.actionLogService = actionLogService;
    }

    @Override
    public List<ActionLog> getActionLog() {
        return actionLogService.getActionLog();
    }

    @Override
    public ActionLog saveActionLog(ActionLog actionLog) {
        actionLogService.saveActionLog(actionLog);

        return actionLog;
    }
}
