package com.akoca.exercise.model.embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Location {
    private double latitude;
    private double longitude;

    private String address;
}