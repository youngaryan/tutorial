package net.codejava.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.codejava.lib.CommonUtil;

@Controller
public class MainController {

	@GetMapping("/")
	public String viewHomePage(Model model) {
		String name = CommonUtil.getAppName();
		model.addAttribute("name",name);
		return "index";
	}
}
