package com.akoca.exercise.controller;

import com.akoca.exercise.config.json.NoteViews;
import com.akoca.exercise.model.Note;
import com.akoca.exercise.service.NoteService;
import com.fasterxml.jackson.annotation.JsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController(value = "/notes")
public class NoteController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoteController.class);

    private NoteService noteService;

    @Autowired     //In Case Another Constructor Created
    NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/{id}")
    @JsonView(NoteViews.Admin.class)
    public ResponseEntity<Note> getOneById(@Positive @PathVariable Long id) {
        Note requestedNote = noteService.getOneById(id);
        return ResponseEntity.ok().body(requestedNote);
    }

    @GetMapping
    @JsonView(NoteViews.Admin.class)
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> allNotes = noteService.getAllNotes();
        return ResponseEntity.ok().body(allNotes);
    }
}