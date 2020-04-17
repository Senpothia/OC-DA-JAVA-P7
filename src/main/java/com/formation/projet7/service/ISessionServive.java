package com.formation.projet7.service;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;

import com.formation.projet7.model.Utilisateur;

public interface ISessionServive {
	
	
	Utilisateur obtenirUserSession(Authentication auth, HttpSession session, Model model);

}
