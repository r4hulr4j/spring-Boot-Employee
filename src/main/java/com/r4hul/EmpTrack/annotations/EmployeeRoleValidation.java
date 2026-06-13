package com.r4hul.EmpTrack.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Constraint(validatedBy = {EmployeeRoleValidationImpl.class})
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmployeeRoleValidation {
    String message() default "{Select ADMIN / USER}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
