package com.r4hul.EmpTrack.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidatorImpl implements ConstraintValidator<PasswordValidator, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        if(s.length() < 10){
            return false;
        }
        boolean isUpper = false;
        boolean isLower = false;
        boolean isSymbol = false;

        for(char ch : s.toCharArray()){
            if(ch >= 'A' && ch <= 'Z'){
                isUpper = true;
            }else if(ch >= 'a' && ch <= 'z'){
                isLower = true;
            }else if(ch >= '0' && ch <= '9'){
                continue;
            }else {
                isSymbol = true;
            }
            if(isLower && isUpper && isSymbol){
                return true;
            }
        }
        return false;
    }
}
