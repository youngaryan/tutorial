package com.ltp.gradesubmission.gradeRepository;

import java.util.ArrayList;
import java.util.List;

import com.ltp.gradesubmission.Grade;

public class GradeRepository {

    public List<Grade> getStudentGrades() {
        return this.studentGrades;
    }

    public void setStudentGrades(List<Grade> studentGrades) {
        this.studentGrades = studentGrades;
    }

    private List<Grade> studentGrades = new ArrayList<>();

}
