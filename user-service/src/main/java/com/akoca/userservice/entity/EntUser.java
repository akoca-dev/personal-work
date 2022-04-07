package com.akoca.userservice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class EntUser extends BaseEntUpdatable {

    @Id
    @GeneratedValue(generator = "SEQ_GEN_USER")
    @SequenceGenerator(name = "SEQ_GEN_USER", sequenceName = "SEQ_USER", initialValue = 100)
    private Long id;

    @Builder.Default
    private boolean isAuthenticated = false;
    private String username;
    private String password;

    @Override
    public Long getId() {
        return id;
    }

    public static EntUser getInstance() {
        return EntUser
                .builder()
                .build();
    }
}