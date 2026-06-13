package com.r4hul.EmpTrack.annotations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {PrimeNumberValidationImpl.class})
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface PrimeNumberValidation {
    String message() default "{Must type a prime Number}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
