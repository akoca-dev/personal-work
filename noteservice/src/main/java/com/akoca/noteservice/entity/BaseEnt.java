package com.akoca.noteservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEnt implements IEnt {

    private Instant createTime;
    private String createdBy;
}
