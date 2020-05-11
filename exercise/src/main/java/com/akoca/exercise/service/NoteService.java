package com.akoca.exercise.service;

import com.akoca.exercise.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;

import java.time.LocalDateTime;
import java.util.List;

public interface NoteService {
    Note getOneById(Long id);
    List<Note> getAllNotes();

    Page<Note> findAllByTitleUsingPages(String title , int pageNum , int pageSize);
    Slice<Note> findAllByTitleUsingSlices(String title , int pageNum , int pageSize);
    List<Note> findAllByTitleUsingList(String title , int pageNum , int pageSize);

    Slice<Note> findByTitleSortByTitleAndCreationTime(String title , LocalDateTime creationTime , int pageNum , int pageSize);
}