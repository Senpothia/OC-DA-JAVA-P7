package com.formation.projet7.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.formation.projet7.model.FormCompte;
import com.formation.projet7.model.Profil;
import com.formation.projet7.model.Utilisateur;

public interface IUserService {
	
	List<Utilisateur> listerUsers();
	Utilisateur obtenirUserParId(Integer id);
	Utilisateur obtenirUser(String string);
	Utilisateur obtenirUserParEmail(String email);
	void modifierUser(Utilisateur user);
	void supprimerUser(Utilisateur user);
	List<Utilisateur> getUserByProfil(Profil profil);
	List<String> getProfil(Authentication auth);
	FormCompte obtenirFormCompte(Utilisateur utilisateur);
	void ajouterUser(Utilisateur user, String role);
	void ajouterRoleUser(Utilisateur user, String role);
	
}
