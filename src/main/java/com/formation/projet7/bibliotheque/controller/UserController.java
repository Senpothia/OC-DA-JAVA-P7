package com.formation.projet7.bibliotheque.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formation.projet7.constants.Constants;
import com.formation.projet7.model.FormCompte;
import com.formation.projet7.model.Utilisateur;
import com.formation.projet7.service.jpa.SessionService;
import com.formation.projet7.service.jpa.UserService;

@Controller
@RequestMapping("/biblio/")
public class UserController {
	
	@Autowired
	SessionService sessionService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/compte/modifier")
	public String modifierCompte(Authentication auth, HttpSession session, Model model) {
		
		Utilisateur user = sessionService.obtenirUserSession(auth, session, model);
		FormCompte formCompte = userService.obtenirFormCompte(user);
		
		model.addAttribute("formCompte", formCompte);	
		return Constants.MODIFIER_COMPTE;
		
	}
	
	
	
	
	

}
