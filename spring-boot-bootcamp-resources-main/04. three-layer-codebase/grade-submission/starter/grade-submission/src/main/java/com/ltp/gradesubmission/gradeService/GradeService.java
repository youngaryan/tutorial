package com.ltp.gradesubmission.gradeService;

import java.util.Arrays;
import java.util.List;

import com.ltp.gradesubmission.Grade;
import com.ltp.gradesubmission.gradeRepository.GradeRepository;

public class GradeService {
    
    private GradeRepository gradeRepository = new GradeRepository();

    public Grade getGrades(int index){
        return gradeRepository.getStudentGrades().get(index);
    } 

    public void addGrade(Grade grade){
        gradeRepository.setStudentGrades(Arrays.asList(grade));
    }

    public void updateGrade(Grade grade, int index){
        gradeRepository.set(index, grade);
    }

    public List<Grade> allGrades(){
        return studentGrades;
    } 
}
