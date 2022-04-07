package com.akoca.noteservice.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ErrorNoAndDescriptionConstants {

    public static final int UNKNOWN_ERROR_NO = 1000;
    public static final String UNKNOWN_ERROR_DESCRIPTION = "Unknown Error Happened";

    public static final int UNIMPLEMENTED_OPERATION_ERROR_NO = 1001;
    public static final String UNIMPLEMENTED_OPERATION_ERROR_DESCRIPTION = "This method is called without an implementation";

    public static final int NOTE_ALREADY_EXISTS_ERROR_NO = 1002;
    public static final String NOTE_ALREADY_EXISTS_ERROR_DESCRIPTION = "This note already exists";
}
