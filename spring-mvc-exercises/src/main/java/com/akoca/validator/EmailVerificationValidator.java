package com.akoca.validator;

import com.akoca.annotation.EmailVerification;
import org.apache.commons.validator.routines.EmailValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailVerificationValidator implements ConstraintValidator<EmailVerification, String> {

    private String message;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        EmailValidator emailValidator = EmailValidator.getInstance();

        if(null == email) {
            return false;
        }

        if(!emailValidator.isValid(email)) {
            return false;
        }

        return true;
    }

    @Override
    public void initialize(EmailVerification constraintAnnotation) {
        message = constraintAnnotation.message();
    }
}
