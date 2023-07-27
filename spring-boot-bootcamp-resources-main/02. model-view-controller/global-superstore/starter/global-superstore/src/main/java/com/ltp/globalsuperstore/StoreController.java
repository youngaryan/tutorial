package com.ltp.globalsuperstore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StoreController {
    static List<Products> orders = new ArrayList<>();

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id){
        int index = getProductIndex(id);

        model.addAttribute("product", index == Constants.NOT_FOUND ? new Products() : orders.get(index));
        model.addAttribute("cats", Constants.CATEGORIES);
        return "form";
    }

    @PostMapping("/proccess")
    public String handleFormPost(Products products, RedirectAttributes redirectAttributes){
        int index = getProductIndex(products.getId());
        String status = Constants.SUCCESS_STATUS;

        if(index == Constants.NOT_FOUND){
            orders.add(products);   
        }else if(within5Days(products.getOrderDate(), orders.get(index).getOrderDate())){
            orders.set(index, products);
        }else{
            status = Constants.FAILED_STATUS;
        }
        
        redirectAttributes.addFlashAttribute("status", status);
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
        return Constants.NOT_FOUND;
    }
    public boolean within5Days(Date newDate, Date oldDate) {
        long diff = Math.abs(newDate.getTime() - oldDate.getTime());
        return (int) (TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
    }

}
