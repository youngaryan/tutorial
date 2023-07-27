package com.ltp.globalsuperstore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StoreController {
    static List<String> categories = Arrays.asList(Constants.CATEGORIES);
    static List<Products> orders = new ArrayList<>();

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id){
        int index = getProductIndex(id);

        model.addAttribute("product", index == -1 ? new Products() : orders.get(index));
        model.addAttribute("cats", categories);
        return "form";
    }

    @PostMapping("/proccess")
    public String handleFormPost(Products products, RedirectAttributes redirectAttributes){
        int index = getProductIndex(products.getId());

        if(index == -1){
            orders.add(products);   
        }else{
            products.setId(orders.get(index).getId());
            orders.set(index, products);
        }
        
        redirectAttributes.addFlashAttribute("message", "You have successfully submited the item.");
        return "redirect:/inventory";
    }

    @GetMapping("/inventory")
    public String inventory(Model model){
        model.addAttribute("orders", orders);
        return "inventory";
    }
    
    public static int getProductIndex(String id){
        for(int i = 0; i < orders.size(); i++){
            if(orders.get(i).getId().equals(id))return i;
        }
        return -1;
    }
}
