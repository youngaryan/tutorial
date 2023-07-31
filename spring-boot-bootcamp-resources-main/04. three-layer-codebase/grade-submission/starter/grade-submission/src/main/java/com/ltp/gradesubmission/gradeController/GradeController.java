package com.ltp.gradesubmission.gradeController;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ltp.gradesubmission.Constants;
import com.ltp.gradesubmission.Grade;
import com.ltp.gradesubmission.gradeRepository.GradeRepository;
import com.ltp.gradesubmission.gradeService.GradeService;

@Controller
public class GradeController {

    private GradeService gradeService = new GradeService();

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        int index = getGradeIndex(id);
        model.addAttribute("grade", index == Constants.NOT_FOUND ? new Grade() : gradeService.getGrades(index));
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(@Valid Grade grade, BindingResult result) {
        if (result.hasErrors()) return "form";

        int index = getGradeIndex(grade.getId());
        if (index == Constants.NOT_FOUND) {
            gradeService.addGrade(grade);
        } else {
            gradeService.updateGrade(grade, index);
        }
        return "redirect:/grades";
    }

    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", gradeService.allGrades());
        return "grades";
    }

    public int getGradeIndex(String id) {
        for (int i = 0; i < gradeService.allGrades().size(); i++) {
            if (gradeService.getGrades(i).getId().equals(id)) return i;
        }
        return Constants.NOT_FOUND;
    }

}