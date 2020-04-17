package com.formation.projet7.service.jpa;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.formation.projet7.model.Utilisateur;
import com.formation.projet7.repository.UserRepo;
import com.formation.projet7.service.ISessionServive;

@Service
public class SessionService implements ISessionServive {

	@Autowired
	UserService userService;
	
	@Override
	public Utilisateur obtenirUserSession(Authentication auth, HttpSession session, Model model) {

		try {
		String username = auth.getName();
		if (username == null) {
			
			model.addAttribute("authentification", false);
			return null;
		}
		Utilisateur user = userService.obtenirUserParEmail(username);
		model.addAttribute("authentification", true);
		model.addAttribute("utilisateur", user);
		return user;
	}  catch (NullPointerException e) {}
		
		return null;
	}
	
	

}
