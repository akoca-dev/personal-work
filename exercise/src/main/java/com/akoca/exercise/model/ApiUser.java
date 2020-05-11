package com.akoca.exercise.model;

import com.akoca.exercise.dbconverters.SecurityAuthorityConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "api_users")
public class ApiUser implements UserDetails , Serializable {

    private static final long serialVersionUID = -653920527321338487L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "api_users_seq")
    @SequenceGenerator(name = "api_users_seq" , sequenceName = "api_users_seq" , allocationSize = 75)
    private Long id;

    private String username;
    private String password;

    @Convert(converter = SecurityAuthorityConverter.class)
    private Set<GrantedAuthority> authorities;

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , orphanRemoval = true , mappedBy = "user", targetEntity = Note.class)
    private Set<Note> notes;
}