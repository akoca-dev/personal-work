package com.akoca.noteservice.service.impl;

import com.akoca.noteservice.entity.EntNote;
import com.akoca.noteservice.enums.OperationResultCode;
import com.akoca.noteservice.repository.NoteRepository;
import com.akoca.noteservice.service.INoteService;
import com.akoca.noteservice.util.OperationResult;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteService implements INoteService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final NoteRepository noteRepository;

    @Override
    public OperationResult<EntNote> addNewNote(EntNote newNote) {

        Optional<EntNote> noteAlreadyExists = noteRepository.findByUniqueId(newNote.getUniqueId());

        if(noteAlreadyExists.isPresent()) {
            OperationResult<EntNote> addNoteOpResult = OperationResult.<EntNote>builder()
                    .operationResultCode(OperationResultCode.NOTE_ALREADY_EXISTS)
                    .build();

            logger.error("Note already exists: {}", newNote.getUniqueId());
            return addNoteOpResult;
        }

        EntNote savedNote = noteRepository.save(newNote);
        return OperationResult.<EntNote>builder()
                .resultData(savedNote)
                .build();
    }

    @Override
    public OperationResult<EntNote> getNoteById(Long noteId) {

        Optional<EntNote> noteOptional = noteRepository.getNoteById(noteId);

        return noteOptional
                .map(entNote ->
                        OperationResult.<EntNote>builder()
                            .resultData(entNote)
                            .operationResultCode(OperationResultCode.GENERAL_SUCCESS_CODE)
                        .build())
                .orElseGet(() ->
                        OperationResult.<EntNote>builder()
                            .operationResultCode(OperationResultCode.GENERAL_SUCCESS_CODE)
                        .build()
                );
    }
}
