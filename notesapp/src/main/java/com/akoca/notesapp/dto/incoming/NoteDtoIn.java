package com.akoca.notesapp.dto.incoming;

import lombok.Data;

@Data
public class NoteDtoIn {
    private String title;
    private String body;

    public NoteDtoIn(String title, String body) {
        this.title = title;
        this.body = body;
    }
}