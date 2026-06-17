package com.r4hul.EmpTrack.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {PasswordValidatorImpl.class})
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordValidator {
    String message() default "{Select correct Password}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
