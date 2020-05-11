package com.akoca.validator;

import com.akoca.annotation.AgeConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeConstraintValidator implements ConstraintValidator<AgeConstraint , Integer>{

    private int lower;
    private int upper;

    @Override
    public boolean isValid(Integer age, ConstraintValidatorContext constraintValidatorContext) {
        if(null == age) {
            return false;
        }
        if(age < 18 || age > 60) {
            return false;
        }

        return true;
    }

    @Override
    public void initialize(AgeConstraint constraintAnnotation) {
        setLower(constraintAnnotation.lower());
        setUpper(constraintAnnotation.upper());
    }

    public int getLower() {
        return lower;
    }

    public void setLower(int lower) {
        this.lower = lower;
    }

    public int getUpper() {
        return upper;
    }

    public void setUpper(int upper) {
        this.upper = upper;
    }
}
