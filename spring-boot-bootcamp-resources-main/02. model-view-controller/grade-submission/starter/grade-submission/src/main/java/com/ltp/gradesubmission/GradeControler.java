package com.ltp.gradesubmission;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GradeControler {

    List<Grades> studentGrades = Arrays.asList(new Grades("Harry", "Math", "C-"),
     new Grades("Alex", "Physics", "B-"),
      new Grades("Josef", "Potions", "A+"));

    @GetMapping("/grades")
    public String getGrades(Model model){
        model.addAttribute("grades", studentGrades);
        return "grades";
    }
}
