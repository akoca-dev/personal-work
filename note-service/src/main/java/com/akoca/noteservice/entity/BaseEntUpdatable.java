package com.akoca.noteservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.MappedSuperclass;
import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntUpdatable extends BaseEnt implements IEntUpdatable {

    @UpdateTimestamp
    private Instant updateTime;
    private String updatedBy;
}
