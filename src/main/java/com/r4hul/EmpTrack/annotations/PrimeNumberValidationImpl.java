package com.r4hul.EmpTrack.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimeNumberValidationImpl implements ConstraintValidator<PrimeNumberValidation, Integer> {

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {


        int value = (int)integer;

        if(value < 2){
            return false;
        }
        for(int i = 2; i*i <= value; i++) {
            if(value % i == 0){
                return false;
            }
        }
        return true;
    }
}
