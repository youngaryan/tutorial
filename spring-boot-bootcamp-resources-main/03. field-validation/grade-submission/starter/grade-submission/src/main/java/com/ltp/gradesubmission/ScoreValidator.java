package com.ltp.gradesubmission;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ScoreValidator implements ConstraintValidator<Score, String> {

    List<String> validScores = Arrays.asList(
        "A*", "A", "A-",
        "B*", "B", "B-",
        "C*", "C", "C-",
        "D*", "D", "D-"
        );
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        for (String string : validScores) {
            if(string.equalsIgnoreCase(value)) return true;
        }
        return false;
    }

}
