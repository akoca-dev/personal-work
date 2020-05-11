package com.akoca.exercise.model.dbquery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LocationCount {
    private String locationAddress;
    private Long locationNoteCount;
}