package com.r4hul.EmpTrack.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmployeeRoleValidationImpl implements ConstraintValidator<EmployeeRoleValidation, String> {
    @Override

    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        String newStr = s.toUpperCase();
        return newStr.equals("ADMIN") || newStr.equals("USER");
    }
}
