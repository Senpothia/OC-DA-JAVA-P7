package com.formation.projet7.bibliotheque.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formation.projet7.constants.Constants;
import com.formation.projet7.model.Profil;
import com.formation.projet7.model.Utilisateur;
import com.formation.projet7.repository.ProfilRepo;
import com.formation.projet7.service.jpa.UserService;


@Controller
@RequestMapping("/biblio")
public class BiblioController {
	
	@Autowired
	private UserService userService;
	@Autowired
	ProfilRepo profilRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	@GetMapping("/")
	public String accueil() {
		
		return Constants.PAGE_ACCUEUIL;
	}
	
	@GetMapping("/presentation")
	public String presentation() {
		
		return Constants.PAGE_PRESENTATION;
	}
	
	@GetMapping("/connexion")
	public String demandeConnexion() {
		
		return Constants.PAGE_CONNEXION;
	}
	
	/**
	@PostMapping("/connexion")
	public String reponseDemandeConnexion() {
		
		return "redirect:/espace";
	}
	*/
	
	
	@GetMapping("/espace")
	public String espace() {
		System.out.println("Connexion réussie!");
		return "ok";
	}
	
	@GetMapping("/compte")
	public String creationCompte(Model model) {
		
		model.addAttribute("utilisateur", new Utilisateur());
		
		return Constants.CREATION_COMPTE;
	}
	
	@PostMapping("/compte")
	public String enregistrementCompte(Utilisateur utilisateur) {
		System.out.println("entree post enreg compte");
		
		utilisateur.setEnabled(true);
		String password = utilisateur.getPassword();
		utilisateur.setPassword(passwordEncoder.encode(password));
		
		Profil profil = profilRepo.getByPerfil("USER");
		List<Profil> profils = utilisateur.getProfils();
		if (profils == null) {
			
			profils = new ArrayList<Profil>();
			profils.add(profil);
		}else {
			
			profils.add(profil);
		}
		
		utilisateur.setProfils(profils);
		userService.ajouterUser(utilisateur);
		
		return "redirect:/";
	}
	
	// Test récupération données de l'utilisateur connecté 
	
	@GetMapping("/user")
	public String infosUtilisateur (Authentication auth) {
		
		String email = auth.getName();
		System.out.println("Email récupéré: " + email);
		
		// Récupération des roles
		
		List<String> profils = userService.getProfil(auth);
		for (String profil : profils) {
			
			System.out.println("Role de l'utilisateur: " + profil);
		}
		return "ok";
		
	
		
	}
	

}
