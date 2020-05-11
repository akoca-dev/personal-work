package com.akoca.notesapp.controller;

import com.akoca.notesapp.dto.incoming.NoteDtoIn;
import com.akoca.notesapp.dto.outgoing.NoteDtoOut;
import com.akoca.notesapp.model.Note;
import com.akoca.notesapp.services.NoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/notes")
@Validated
public class NoteController {

    private final ModelMapper modelMapper;
    private final NoteService noteService;

    @PostMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<NoteDtoOut> composeNewNote(@Valid @RequestBody NoteDtoIn newNoteDtoIn) {
        Note newNote = modelMapper.map(newNoteDtoIn, Note.class);

        return noteService.save(newNote).map(note -> modelMapper.map(note, NoteDtoOut.class));
    }
}