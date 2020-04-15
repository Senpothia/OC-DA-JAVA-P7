package com.formation.projet7.bibliotheque.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.formation.projet7.model.User;
import com.formation.projet7.model.UserRole;
import com.formation.projet7.model.Utilisateur;
import com.formation.projet7.repository.UserRepo;
import com.formation.projet7.repository.UserRoleRepo;

@Controller
@RequestMapping("/biblio")
public class BiblioController {

	private final UserRepo userRepo;
	private final UserRoleRepo userRoleRepo;
	private final PasswordEncoder passwordEncoder;

	public BiblioController(UserRepo userRepo, PasswordEncoder passwordEncoder, UserRoleRepo userRoleRepo) {
		
		this.passwordEncoder = passwordEncoder;
		this.userRepo = userRepo;
		this.userRoleRepo = userRoleRepo;
	}

	@GetMapping("/")
	public String accueil() {

		return "index";
	}

	@GetMapping("/presentation")
	public String presentation() {

		return "presentation";
	}

	@GetMapping("/connexion")
	public String connexion(@RequestParam(name = "error", required = false) boolean error
			, Model model
			,HttpSession session
			, HttpServletRequest request) {

		try {

			String email = request.getUserPrincipal().getName();
			System.out.println("email récupéré get connexion - get: " + email);

			model.addAttribute("utilisateur", userRepo.findByUsername(email));
			model.addAttribute("authentification", true);

		} catch (NullPointerException e) {

			System.out.println("email récupéré connexion - get: aucun!!!");
			model.addAttribute("authentification", false);
		}
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("error", error);
		model.addAttribute("phrase", new String());
		return "connexion";

	}
	

	@GetMapping("/espace")     // Espace personnel
	public String espace() {

		return "ok";
	}

	@GetMapping("/compte")      // Création de compte
	public String creerCompte(Model model) {

		model.addAttribute("authentification", false);
		model.addAttribute("utilisateur", new Utilisateur());
		return "compte";
	}

	@PostMapping("/compte")		// création de compte - enregistrement données de compte
	public String compteSubmit(@ModelAttribute Utilisateur utilisateur, Model model) {
		
		System.out.println("Enregistrement compte");
		utilisateur.setPassword(passwordEncoder.encode(utilisateur.getUsername()));
		utilisateur.setEnabled(true);
		
		Set<UserRole> userRole = new HashSet<UserRole>();
		UserRole role = new UserRole();
		role.setRole("USER");
		role.setUser(utilisateur);
		userRole.add(role);
		utilisateur.setUserRole(userRole);
		
		try {
			
			//userRoleRepo.save(role);
			userRepo.save(utilisateur);
			//model.addAttribute("utilisateur", userRepo.findByUsername(email));
			model.addAttribute("authentification", true);
			return "accueil";

		} catch (Exception e) { // enregistrement échoué, problème d'unicité sur email

			System.out.println("Violation unicité email");
			model.addAttribute("utilisateur", new Utilisateur());
			model.addAttribute("echec", true);
			return "index";
		}

	}
	
	@GetMapping("/biblio/espace")    // Accès espace personnel
	public String espace( Model model, HttpServletRequest request, Principal principal) {
		String email = request.getUserPrincipal().getName();
		model.addAttribute("utilisateur", userRepo.findByUsername(email));
		
		Utilisateur utilisateur = userRepo.findByUsername(email);
		if (utilisateur.isEnabled()) {
			
			System.out.println("User actif");
			return "espace";
		} else {
			
			System.out.println("User inactif!!!");
			return "index";
		
		}
		
	}
	
	

}
