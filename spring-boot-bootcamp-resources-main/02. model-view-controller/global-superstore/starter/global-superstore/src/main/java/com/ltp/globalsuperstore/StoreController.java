package com.ltp.globalsuperstore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StoreController {
    static List<String> categories = Arrays.asList(Constants.CATEGORIES);
    static List<Products> orders = new ArrayList<>();

    @GetMapping("/")
    public String getForm(Model model){
       
        model.addAttribute("product", new Products());
        model.addAttribute("cats", categories);
        return "form";
    }

    @PostMapping("/proccess")
    public String handleFormPost(Products products){
        orders.add(products);
        return "redirect:inventory";
    }

    @GetMapping("/inventory")
    public String inventory(Model model){
        model.addAttribute("orders", orders);
        return "inventory";
    }
    
}
