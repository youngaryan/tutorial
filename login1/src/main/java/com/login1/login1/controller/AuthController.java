package com.login1.login1.controller;

import com.login1.login1.entity.Role;
import com.login1.login1.entity.UserEntity;
import com.login1.login1.repository.RoleRepository;
import com.login1.login1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;


    @GetMapping("/index")
    public String showHomePage(Model model) {
        List<UserEntity> allUsers = userService.findAllUsers();
        model.addAttribute("users",allUsers);
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
    public String r(@ModelAttribute("userEntity") UserEntity user, @RequestParam("myRadio") String role){

        userService.register(user.getEmail(), user.getPassword(), role);
        return "success";
    }

    @PostMapping("/resettingPasswordSendEmail")
    public String resettingPasswordSendEmail(@RequestParam("email") String email, Model model) {
        UserEntity user = userService.findByEmail(email);
        userService.setJavaMailSender(email);
        model.addAttribute("user", user);
        return "/checkAuth";
    }
    @PostMapping("/checkAuth")
    public String checkAuth( @RequestParam("code") String code, Model model) {
        boolean pinMatches = userService.existByPin(code);
        model.addAttribute("code",code);
        model.addAttribute("pinMatches", pinMatches);
        return "checkAuth";
    }

    @Transactional
    @PostMapping("/resetPassword")
    public String resetPass(@RequestParam("code1") String code, @RequestParam("newPassword") String newPass ) {
        UserEntity user = userService.findByPin(code);
        user.setPassword(newPass);
        user.setPin(null);
        return "success";
    }

}
