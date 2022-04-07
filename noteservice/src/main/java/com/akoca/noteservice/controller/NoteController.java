package com.akoca.noteservice.controller;

import com.akoca.noteservice.dto.add.DtoCrtNote;
import com.akoca.noteservice.dto.delete.DtoDelNote;
import com.akoca.noteservice.dto.read.DtoReadNote;
import com.akoca.noteservice.dto.update.DtoUpdNote;
import com.akoca.noteservice.entity.EntNote;
import com.akoca.noteservice.service.INoteService;
import com.akoca.noteservice.util.ExecutionTimer;
import com.akoca.noteservice.util.OperationResult;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class NoteController {

    private final INoteService noteService;

    public OperationResult<EntNote> addNote(DtoCrtNote dtoCrtNote) {
        ExecutionTimer executionTimer = ExecutionTimer.getStartedInstance();
        EntNote newNote = dtoCrtNote.convertToEntity();

        OperationResult<EntNote> addNoteOpResult = noteService.addNewNote(newNote);

        addNoteOpResult.setExecutionTimer(executionTimer.stopTimer());
        return addNoteOpResult;
    }

    public OperationResult<EntNote> deleteNote(DtoDelNote dtoDelNote) {
        return null;
    }

    public OperationResult<EntNote> updateNote(DtoUpdNote dtoUpdNote) {
        return null;
    }

    public OperationResult<EntNote> readNote(DtoReadNote dtoReadNote) {
        ExecutionTimer executionTimer = ExecutionTimer.getStartedInstance();

        OperationResult<EntNote> getNoteOpResult = noteService.getNoteById(dtoReadNote.getId());

        getNoteOpResult.setExecutionTimer(executionTimer.stopTimer());
        return getNoteOpResult;
    }
}
