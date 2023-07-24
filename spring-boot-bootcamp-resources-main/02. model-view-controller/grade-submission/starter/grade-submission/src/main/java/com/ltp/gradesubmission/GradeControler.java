package com.ltp.gradesubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GradeControler {

    @GetMapping("/grades")
    public String getGrades(Model model){
        Grades grade = new Grades("Harry", "Math", "C-");
        model.addAttribute("grade", grade);
        return "grades";
    }
}
