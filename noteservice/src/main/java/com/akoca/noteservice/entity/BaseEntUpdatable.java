package com.akoca.noteservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntUpdatable extends BaseEnt implements IEntUpdatable {

    private Instant updateTime;
    private String updatedBy;
}
