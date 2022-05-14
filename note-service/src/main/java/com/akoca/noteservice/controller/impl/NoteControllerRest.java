package com.akoca.noteservice.controller.impl;

import com.akoca.noteservice.controller.NoteController;
import com.akoca.noteservice.dto.add.DtoCrtNote;
import com.akoca.noteservice.dto.delete.DtoDelNote;
import com.akoca.noteservice.dto.read.DtoReadNote;
import com.akoca.noteservice.dto.update.DtoUpdNote;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "notes")
public class NoteControllerRest {

    private final NoteController noteController;

    @PostMapping
    public ResponseEntity<String> addNote(DtoCrtNote dtoCrtNote) {
        return noteController
                .addNote(dtoCrtNote)
                .generateResponseEntity();
    }

    @DeleteMapping
    public ResponseEntity<String> deleteNote(DtoDelNote dtoDelNote) {
        return noteController
                .deleteNote(dtoDelNote)
                .generateResponseEntity();
    }

    @PutMapping
    public ResponseEntity<String> updateNote(DtoUpdNote dtoUpdNote) {
        return noteController
                .updateNote(dtoUpdNote)
                .generateResponseEntity();
    }

    @GetMapping
    public ResponseEntity<String> readNote(DtoReadNote dtoReadNote) {
        return noteController
                .readNote(dtoReadNote)
                .generateResponseEntity();
    }
}