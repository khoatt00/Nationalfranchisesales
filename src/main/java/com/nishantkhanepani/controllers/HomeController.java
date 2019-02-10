package com.nishantkhanepani.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="/home",method=RequestMethod.POST)
	public String home(@RequestParam("username") String input,Model model) {
		model.addAttribute("controllerName",input);
		return "input";
	}
}
