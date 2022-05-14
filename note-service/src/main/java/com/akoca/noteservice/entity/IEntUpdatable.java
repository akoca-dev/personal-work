package com.akoca.noteservice.entity;

import java.time.Instant;

public interface IEntUpdatable extends IEnt {

    Instant getUpdateTime();
    String getUpdatedBy();
}
