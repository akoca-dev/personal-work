package com.akoca.notesapp.services.impl;

import com.akoca.notesapp.model.Note;
import com.akoca.notesapp.repository.NoteRepository;
import com.akoca.notesapp.services.NoteService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Slf4j
@Data
@Service
@Transactional
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Override
    public Mono<Note> save(Note note) {
        return noteRepository.save(note);
    }
}
