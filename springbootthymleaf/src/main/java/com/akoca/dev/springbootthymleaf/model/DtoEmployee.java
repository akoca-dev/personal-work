package com.akoca.dev.springbootthymleaf.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoEmployee {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
}
