package com.formation.projet7.bibliotheque.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formation.projet7.constants.Constants;
import com.formation.projet7.model.Utilisateur;
import com.formation.projet7.service.jpa.SessionService;

@Controller
@RequestMapping("/biblio/")
public class UsageController {
	
	@Autowired
	SessionService sessionService;
	
	@GetMapping("/emprunts")
	public String tableEmprunts(Authentication auth, HttpSession session, Model model) {
		
		Utilisateur user = sessionService.obtenirUserSession(auth, session, model);
		return Constants.EMPRUNTS;
	}
	
	@GetMapping("/rubriques")
	public String rubriques(Authentication auth, HttpSession session, Model model) {
		Utilisateur user = sessionService.obtenirUserSession(auth, session, model);
		model.addAttribute("historique", false);
		return Constants.RUBRIQUES;
	}
	
	@GetMapping("/emprunts/historique/")
	public String tableEmpruntsHist(Authentication auth, HttpSession session, Model model) {
		
		Utilisateur user = sessionService.obtenirUserSession(auth, session, model);
		model.addAttribute("historique", true);
		return Constants.EMPRUNTS;
	}
	

}
