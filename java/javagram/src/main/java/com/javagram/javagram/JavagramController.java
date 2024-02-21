package com.javagram.javagram;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class JavagramController {

    @GetMapping("/")
    public String getForm(Model model){
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @PostMapping("/submitItem")
        public String handleForm(@Valid User user, BindingResult result){
            if(user.getFirstName().equalsIgnoreCase(user.getLastName()))result.rejectValue("lastName", "","please enter valid data.");
            if(result.hasErrors() == true){
                return "/sign-up";
            }


            return "redirect:/result";
        }

    @GetMapping("/result")
    public String getResult() {
        return "result";
    }

}
