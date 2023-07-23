package com.ltp.workbook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * MovieController
 */
@Controller
public class MovieController {
    @GetMapping("/shows")
    public String showTable(){
        return "/shows";
    }
}