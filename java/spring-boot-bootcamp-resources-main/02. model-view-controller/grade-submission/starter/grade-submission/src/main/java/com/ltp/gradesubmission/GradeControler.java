package com.ltp.gradesubmission;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GradeControler {

    List<Grades> studentGrades = new ArrayList<>();

    @GetMapping("/grades")
    public String getGrades(Model model){
        model.addAttribute("grades", studentGrades);
        return "grades";
    }

    @GetMapping("/")
    public String gradeForm(Model model, @RequestParam(required = false) String id){
        int index = getGradeIndex(id);
        model.addAttribute("gradeF", index == Constants.NOT_FOUND ?new Grades(): studentGrades.get(index));
        return "form";
    }

    @PostMapping("/handleSubmmit")
    public String submitGrade(Grades grades){
        int index = getGradeIndex(grades.getId());
        if(index == Constants.NOT_FOUND){
            studentGrades.add(grades);
        }else{
            studentGrades.set(index, grades);
        }
        return "redirect:/grades";
    }

    public int getGradeIndex(String id){
        for (int i = 0; i < studentGrades.size(); i++) {
            if(studentGrades.get(i).getId().equals(id)) return i;
        }
        return Constants.NOT_FOUND;
    }
}
