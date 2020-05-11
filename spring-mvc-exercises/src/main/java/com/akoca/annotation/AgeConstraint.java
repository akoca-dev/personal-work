package com.akoca.annotation;

import com.akoca.validator.AgeConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = AgeConstraintValidator.class)
public @interface AgeConstraint {

    String message() default "Age must be 18-60 years";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int lower() default 18;

    int upper() default 60;
}
