package com.login1.login1.controller;

import com.login1.login1.entity.UserEntity;
import com.login1.login1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String showHomePage() {
        return "index";
    }


    @GetMapping("/login")
    public String log(Model model){
        UserEntity user = new UserEntity();
        model.addAttribute("user",user);
        return "login";
    }
    @PostMapping("/login")
    public String l(@ModelAttribute("user") UserEntity user){
        if (userService.checkLogIn(user.getEmail(), user.getPassword())){
            return "redirect:/index";
        }
        return "login";
    }

    @GetMapping("/register")
    public String reg(Model model){
        model.addAttribute("userEntity",new UserEntity());
        return "register";
    }
    @PostMapping("/register")
    public String r(@ModelAttribute("userEntity") UserEntity user){
        userService.register(user.getEmail(), user.getPassword());
        return "success";
    }
}
