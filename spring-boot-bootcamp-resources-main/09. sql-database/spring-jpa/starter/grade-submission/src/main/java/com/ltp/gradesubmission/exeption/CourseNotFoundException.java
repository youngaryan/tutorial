package com.ltp.gradesubmission.exeption;

public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(Long id) {
        super("The course id '" + id + "' does not exist in our records");
    }

}