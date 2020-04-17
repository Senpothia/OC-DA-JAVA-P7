package com.formation.projet7.bibliotheque.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.formation.projet7.service.jpa.SessionService;
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
	@Autowired
	SessionService sessionService;
	
	@GetMapping("/")
	public String accueil(Authentication auth, HttpSession session, Model model) {
	
		Utilisateur user = sessionService.obtenirUserSession(auth, session, model);
		return Constants.PAGE_ACCUEUIL;
	}
	
	@GetMapping("/presentation")
	public String presentation(Authentication auth, HttpSession session, Model model) {
		
		Utilisateur user = sessionService.obtenirUserSession(auth, session, model);
		return Constants.PAGE_PRESENTATION;
	}
	
	@GetMapping("/connexion")
	public String demandeConnexion() {
		
		return Constants.PAGE_CONNEXION;
	}
	
	@GetMapping("/espace")
	public String espace(Authentication auth, HttpSession session, Model model) {
		
		System.out.println("Connexion réussie!");
		Utilisateur user = sessionService.obtenirUserSession(auth, session, model);
		return "ok";
	}
	
	@GetMapping("/compte")    // Transmission formulaire de création de compte
	public String creationCompte(Model model) {
		
		model.addAttribute("utilisateur", new Utilisateur());
		
		return Constants.CREATION_COMPTE;
	}
	
	@PostMapping("/compte")    // Enregistrement d'un compte
	public String enregistrementCompte(Utilisateur utilisateur, HttpSession session) {
		
		userService.ajouterUser(utilisateur);
		session.setAttribute("USER", utilisateur);
		session.setAttribute("authentification", true);
		
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
