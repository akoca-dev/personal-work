package com.akoca.notesapp.services;

import com.akoca.notesapp.model.Note;
import reactor.core.publisher.Mono;

public interface NoteService {
    Mono<Note> save(Note note);
}
