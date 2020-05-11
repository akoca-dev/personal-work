package com.akoca.logservice.services;

import com.akoca.logservice.model.ActionLog;

import java.util.List;

public interface LogService {

    List<ActionLog> getActionLog();

    ActionLog saveActionLog(ActionLog actionLog);
}
