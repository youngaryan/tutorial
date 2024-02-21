package com.javagram.javagram;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

//$ % # @ ^ *

public class UsernameValidator implements ConstraintValidator<Username, String> {

    List<Character> invalidCharacters = Arrays.asList('$', '%', '#', '@', '^', '*');
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Pattern pattern = Pattern.compile("[^a-z0-9 ]");
        Matcher matcher = pattern.matcher(value);
        return !matcher.find(); //false if characters are a-z or 0-9
    }

}
