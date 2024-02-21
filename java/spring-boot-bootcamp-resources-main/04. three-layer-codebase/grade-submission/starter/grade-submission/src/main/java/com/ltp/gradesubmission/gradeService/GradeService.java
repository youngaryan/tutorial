package com.ltp.gradesubmission.gradeService;
import java.util.List;

import com.ltp.gradesubmission.Constants;
import com.ltp.gradesubmission.Grade;
import com.ltp.gradesubmission.gradeRepository.GradeRepository;

public class GradeService {
    
    private GradeRepository gradeRepository = new GradeRepository();

    public Grade getGrades(int index){
        return gradeRepository.getGrades(index);
    } 

    public void addGrade(Grade grade){
        gradeRepository.addGrade(grade);
    }

    public void updateGrade(Grade grade, int index){
        gradeRepository.updateGrade(grade, index);
    }

    public List<Grade> allGrades(){
        return gradeRepository.allGrades();
    } 

    public int getGradeIndex(String id) {
        for (int i = 0; i < allGrades().size(); i++) {
            if (getGrades(i).getId().equals(id)) return i;
        }
        return Constants.NOT_FOUND;
    }

    public Grade getGradeById(String id){
        int index = getGradeIndex(id);
        return index == Constants.NOT_FOUND ? new Grade() : getGrades(index);
    }

    public void submitGrade(Grade grade){
        int index = getGradeIndex(grade.getId());
        if (index == Constants.NOT_FOUND) {
            addGrade(grade);
        } else {
            updateGrade(grade, index);
        }
    }
}
