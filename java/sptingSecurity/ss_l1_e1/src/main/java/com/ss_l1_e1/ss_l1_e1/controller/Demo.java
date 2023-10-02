package com.ss_l1_e1.ss_l1_e1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {

    @GetMapping("/hello")
    public String hello() {
        return "hello!";
    }
}