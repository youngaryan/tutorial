package com.example.demo.controller;

import com.example.demo.servise.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    //handler method to handle list of students and return mode and view
    @GetMapping("/students")
    public String listStudents(Model model){
        model.addAttribute(",",studentService.getAllStudents());
        return "students";
    }
}
