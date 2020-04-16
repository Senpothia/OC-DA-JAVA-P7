package com.formation.projet7.bibliotheque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formation.projet7.model.Utilisateur;
import com.formation.projet7.service.jpa.UserService;


@Controller
@RequestMapping("/biblio")
public class BiblioController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	

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
	
	@PostMapping("connexion")
	public String entreeDemandeConnexion() {
		
		return "ok";
	}
	
	@GetMapping("/espace")
	public String espace() {
		
		return "espace";
	}
	
	@GetMapping("/compte")
	public String creationCompte(Model model) {
		
		model.addAttribute("utilisateur", new Utilisateur());
		
		return "compte";
	}
	
	@PostMapping("/compte")
	public String enregistrementCompte(Utilisateur utilisateur) {
		System.out.println("entree post enreg compte");
		
		utilisateur.setEnabled(true);
		userService.ajouterUser(utilisateur);
		String password = utilisateur.getPassword();
		utilisateur.setPassword(passwordEncoder.encode(password));
		
		
		return "redirect:/";
	}
	

}
