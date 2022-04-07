package com.akoca.userservice.enums;

import com.akoca.userservice.util.ErrorNoAndDescriptionConstants;
import com.akoca.userservice.util.SuccessNoAndDescriptionConstants;

import java.util.Arrays;
import java.util.Optional;

public enum OperationResultCode {
    //SUCCESS CODES START HERE
    GENERAL_SUCCESS_CODE(SuccessNoAndDescriptionConstants.GENERAL_SUCCESS_NO, SuccessNoAndDescriptionConstants.GENERAL_SUCCESS_DESCRIPTION),
    //SUCCESS CODES END HERE

    //ERROR CODES START HERE
    UNKNOWN_ERROR(ErrorNoAndDescriptionConstants.UNKNOWN_ERROR_NO, ErrorNoAndDescriptionConstants.UNKNOWN_ERROR_DESCRIPTION),
    UNEXPECTED_ERROR(ErrorNoAndDescriptionConstants.UNEXPECTED_RUNTIME_ERROR_NO, ErrorNoAndDescriptionConstants.UNEXPECTED_RUNTIME_ERROR_DESCRIPTION),
    UNIMPLEMENTED_OPERATION(ErrorNoAndDescriptionConstants.UNIMPLEMENTED_OPERATION_ERROR_NO, ErrorNoAndDescriptionConstants.UNIMPLEMENTED_OPERATION_ERROR_DESCRIPTION),
    USER_ALREADY_EXISTS(ErrorNoAndDescriptionConstants.USER_ALREADY_EXISTS_ERROR_NO, ErrorNoAndDescriptionConstants.USER_ALREADY_EXISTS_ERROR_DESCRIPTION),
    USER_NOT_FOUND(ErrorNoAndDescriptionConstants.USER_NOT_FOUND_ERROR_NO, ErrorNoAndDescriptionConstants.USER_NOT_FOUND_ERROR_DESCRIPTION)
    ;
    //ERROR CODES END HERE

    private final int resultNo;
    private final String resultDescription;

    OperationResultCode(int resultNo, String resultDescription) {
        this.resultNo = resultNo;
        this.resultDescription = resultDescription;
    }

    public int getResultCodeNo() {
        return resultNo;
    }

    public String getResultCodeDescription() {
        return resultDescription;
    }

    public Optional<OperationResultCode> getResultCodeFromCodeNo(int codeNo) {
        return
                Arrays.stream(OperationResultCode.values())
                        .takeWhile(resultCodeEnum -> resultCodeEnum.getResultCodeNo() == codeNo)
                        .findAny();
    }

    public boolean isOperationResultCode(int codeNo) {
        return getResultCodeFromCodeNo(codeNo).isPresent();
    }
}
