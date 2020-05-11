package com.akoca.validator;

import com.akoca.annotation.FieldsVerification;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldsVerificationValidator implements ConstraintValidator<FieldsVerification , Object> {

    private String field;
    private String fieldMatch;

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {

        Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(field);
        Object fieldMatchValue = new BeanWrapperImpl(value).getPropertyValue(fieldMatch);

        if(null != fieldMatchValue && null != fieldValue) {
            return fieldValue.equals(fieldMatchValue);
        }

        return null == fieldMatchValue;
    }

    @Override
    public void initialize(FieldsVerification constraintAnnotation) {
        field = constraintAnnotation.field();
        fieldMatch = constraintAnnotation.fieldMatch();
    }
}
