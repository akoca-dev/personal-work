package com.akoca.noteservice.service;

import com.akoca.noteservice.entity.EntNote;
import com.akoca.noteservice.util.OperationResult;

public interface INoteService {
    OperationResult<EntNote> addNewNote(EntNote newNote);

    OperationResult<EntNote> getNoteById(Long noteId);
}
