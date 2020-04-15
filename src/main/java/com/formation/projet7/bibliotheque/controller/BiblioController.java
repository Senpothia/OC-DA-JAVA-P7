package com.formation.projet7.bibliotheque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/biblio")
public class BiblioController {
	
	@GetMapping("/")
	public String accueil() {
		
		return "index";
	}
	
	@GetMapping("/presentation")
	public String presentation() {
		
		return "presentation";
	}
	
	@GetMapping("/connexion")
	public String connexion() {
		
		return "connexion";
	}
	
	@GetMapping("/espace")
	public String espace() {
		
		return "espace";
	}
	

}
