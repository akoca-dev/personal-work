package com.akoca.exercise.service.impl;

import com.akoca.exercise.model.Note;
import com.akoca.exercise.repository.NoteRepository;
import com.akoca.exercise.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {

    private NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note getOneById(Long id) {
        return noteRepository.getOne(id);
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Page<Note> findAllByTitleUsingPages(String title , int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum , pageSize);
        return noteRepository.findByTitleReturnAsPage(title , pageable);
    }

    @Override
    public Slice<Note> findAllByTitleUsingSlices(String title , int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum , pageSize);
        return noteRepository.findByTitleReturnAsSlice(title , pageable);
    }

    @Override
    public List<Note> findAllByTitleUsingList(String title , int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum , pageSize);
        return noteRepository.findByTitleReturnAsList(title , pageable);
    }

    @Override
    public Slice<Note> findByTitleSortByTitleAndCreationTime(String title, LocalDateTime creationTime , int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum , pageSize , Sort.by("title").ascending().and(Sort.by("creationTime").descending()));
        return noteRepository.findByTitleReturnAsSlice(title , pageable);
    }
}