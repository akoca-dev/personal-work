package com.akoca.notesapp.repository;

import com.akoca.notesapp.model.Note;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends ReactiveCrudRepository<Note, Long> {
}