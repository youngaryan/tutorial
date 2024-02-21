package com.ss_l2_2.ss_l2_2.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public String dempo() {
        var u = SecurityContextHolder.getContext().getAuthentication();

        u.getAuthorities().forEach(a -> System.out.println(a));
        return "demo";
    }
}
