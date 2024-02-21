package com.ltp.gradesubmission.gradeRepository;

import java.util.ArrayList;
import java.util.List;

import com.ltp.gradesubmission.Grade;

public class GradeRepository {

    private List<Grade> studentGrades = new ArrayList<>();

     public Grade getGrades(int index){
        return studentGrades.get(index);
    } 

    public void addGrade(Grade grade){
        studentGrades.add(grade);;
    }

    public void updateGrade(Grade grade, int index){
        studentGrades.set(index, grade);
    }

    public List<Grade> allGrades(){
        return studentGrades;
    } 

}
