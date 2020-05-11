package com.akoca.exercise.model;

import com.akoca.exercise.config.json.NoteViews;
import com.akoca.exercise.model.embeddable.Location;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "notes")
public class Note implements Serializable {

    private static final long serialVersionUID = -32142342342442423L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "notes_seq")
    @SequenceGenerator(name = "note_seq" , sequenceName = "notes_seq" , allocationSize = 75)
    @JsonView(NoteViews.Admin.class)
    private Long id;

    private String title;
    private String body;

    private LocalDateTime creationTime;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "latitude" , column = @Column(name = "loc_latitude")) ,
            @AttributeOverride(name = "longitude" , column = @Column(name = "loc_longitude")) ,
            @AttributeOverride(name = "address" , column = @Column(name = "loc_address"))
    })
    @JsonView(NoteViews.Friend.class)
    private Location noteLocation;

    @JsonView(NoteViews.Admin.class)
    @ManyToOne(optional = false , targetEntity = ApiUser.class , fetch = FetchType.EAGER)
    private ApiUser user;
}