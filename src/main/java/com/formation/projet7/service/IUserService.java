package com.formation.projet7.service;

import java.util.List;

import com.formation.projet7.model.User;

public interface IUserService {
	
	List<User> listerUser();
	User obtenirUser(Integer id);
	User obtenirUser(String string);
	User obtenirUserParEmail(String email);
	void ajouterUser(User user);
	void modifierUser(User user);
	void supprimerUser(User user);
	
}
