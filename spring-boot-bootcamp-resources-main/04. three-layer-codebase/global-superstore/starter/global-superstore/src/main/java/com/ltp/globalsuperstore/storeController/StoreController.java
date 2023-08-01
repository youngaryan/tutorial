package com.ltp.globalsuperstore.storeController;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ltp.globalsuperstore.Item;
import com.ltp.globalsuperstore.storeService.Service;

@Controller
public class StoreController {

   private Service service = new Service();

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        model.addAttribute("item", service.handleSubmit(id));
        return "form";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(@Valid Item item, BindingResult result, RedirectAttributes redirectAttributes) {
        if (service.discountCheck(item)) {
            result.rejectValue("price", "", "Price cannot be less than discount");
        }
        if (result.hasErrors()) return "form";
        
        redirectAttributes.addFlashAttribute("status", service.handleStatus(item));
        return "redirect:/inventory";
    }

    @GetMapping("/inventory")
    public String getInventory(Model model) {
        model.addAttribute("items", service.getAllItems());
        return "inventory";
    }

}
