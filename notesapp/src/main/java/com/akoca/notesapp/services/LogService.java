package com.akoca.notesapp.services;

import com.akoca.notesapp.exceptionhandling.BaseCheckedException;
import com.akoca.notesapp.exceptionhandling.BaseUncheckedException;

public interface LogService {
    void logBaseCheckedException(BaseCheckedException baseCheckedException);

    void logBaseUncheckedException(BaseUncheckedException baseUncheckedException);

    void logRegularException(Exception exception);
}