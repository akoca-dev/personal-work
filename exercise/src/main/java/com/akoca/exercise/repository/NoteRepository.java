package com.akoca.exercise.repository;

import com.akoca.exercise.model.Note;
import com.akoca.exercise.model.dbquery.LocationCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note , Long> {
    List<Note> findByTitleReturnAsList(String title , Pageable pageable);

    Slice<Note> findByTitleReturnAsSlice(String title , Pageable pageable);

    Page<Note> findByTitleReturnAsPage(String title , Pageable pageable);

    @Query(value = "select " +
            "n.loc_address as locationAddress , count(n) as locationNoteCount " +
            "from notes n " +
            "group by n.loc_address " +
            "order by locationNoteCount desc" , nativeQuery = true)
    List<LocationCount> findLocationCounts();
}