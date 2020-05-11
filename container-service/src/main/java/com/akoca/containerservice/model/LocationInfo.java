package com.akoca.containerservice.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Embeddable
public class LocationInfo {
    private double latitude;
    private double longitude;
}
