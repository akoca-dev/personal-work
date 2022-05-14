package com.akoca.noteservice.repository;

import com.akoca.noteservice.entity.EntNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<EntNote, Long> {

    Optional<EntNote> findByUniqueId(String entNoteUniqueId);

    Optional<EntNote> getNoteById(Long noteId);
}
