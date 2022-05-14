package com.akoca.noteservice.entity;

import java.time.Instant;

public interface IEnt {
    String getId();

    Instant getCreateTime();

    String getCreatedBy();
}
