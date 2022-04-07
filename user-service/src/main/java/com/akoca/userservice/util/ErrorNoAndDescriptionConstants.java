package com.akoca.userservice.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ErrorNoAndDescriptionConstants {

    public static final int UNKNOWN_ERROR_NO = 1000;
    public static final String UNKNOWN_ERROR_DESCRIPTION = "Unknown Error Happened";

    public static final int UNIMPLEMENTED_OPERATION_ERROR_NO = 1001;
    public static final String UNIMPLEMENTED_OPERATION_ERROR_DESCRIPTION = "This method is called without an implementation";

    public static final int USER_ALREADY_EXISTS_ERROR_NO = 1002;
    public static final String USER_ALREADY_EXISTS_ERROR_DESCRIPTION = "This user already exists";

    public static final int USER_NOT_FOUND_ERROR_NO = 1003;
    public static final String USER_NOT_FOUND_ERROR_DESCRIPTION = "This user not found";

    public static final int UNEXPECTED_RUNTIME_ERROR_NO = 1004;
    public static final String UNEXPECTED_RUNTIME_ERROR_DESCRIPTION = "Unexpected runtime error happened";
}
