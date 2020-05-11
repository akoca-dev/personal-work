package com.akoca.annotation;

import com.akoca.validator.EmailVerificationValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = EmailVerificationValidator.class)

public @interface EmailVerification {

    String message() default "Mail is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
