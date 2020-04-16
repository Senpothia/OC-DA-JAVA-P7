package com.formation.projet7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String showLoginForm(Model model,
			@RequestParam(name = "error", required = false) String error)
			 {
		
		model.addAttribute("error", error);
		
		return "connexion";
	}
	
	@GetMapping("/loginsuccess")
	public String loginCheck() {
		
		return "ok";
	}
	
}
