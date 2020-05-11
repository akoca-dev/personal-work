package com.akoca.notesapp.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(value = "note")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "note_seq")
    @SequenceGenerator(name = "note_seq", sequenceName = "note_seq")
    private Long id;

    private String title;
    private String body;

    private OffsetDateTime noteTime;
}