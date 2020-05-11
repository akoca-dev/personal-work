package com.akoca.containerservice.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Entity
@Table
public class Container {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "container_seq")
    @SequenceGenerator(name = "container_seq", sequenceName = "container_seq")
    private Long id;

    private int fillPercentage;

    @Embedded
    private LocationInfo locationInfo;
}
