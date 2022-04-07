package com.akoca.userservice.entity;

import java.time.Instant;

public interface IEnt {
    Long getId();

    Instant getCreateTime();

    String getCreatedBy();
}
