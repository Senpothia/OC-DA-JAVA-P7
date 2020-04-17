package com.formation.projet7.service.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.formation.projet7.model.Profil;
import com.formation.projet7.model.Utilisateur;
import com.formation.projet7.repository.ProfilRepo;
import com.formation.projet7.repository.UserRepo;
import com.formation.projet7.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepo userRepo;
	
	@Override
	public List<Utilisateur> listerUsers() {
		
		List<Utilisateur> users = userRepo.findAll();
		return users;
	}

	@Override
	public Utilisateur obtenirUser(Integer id) {
		
		Utilisateur user = userRepo.getOne(id);
		return user;
	}

	@Override
	public Utilisateur obtenirUser(String string) {
		
		//User user = userRepo.findByIdentity(string);
		return null;
	}

	@Override
	public Utilisateur obtenirUserParEmail(String email) {

		Utilisateur user = userRepo.findByUsername(email);
		return user;
	}

	@Override
	public void ajouterUser(Utilisateur user) {
		userRepo.save(user);
		
	}

	@Override
	public void modifierUser(Utilisateur user) {
		userRepo.save(user);
		
	}

	@Override
	public void supprimerUser(Utilisateur user) {
		userRepo.delete(user);
		
	}

	@Override
	public List<Utilisateur> getUserByProfil(Profil profil) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getProfil(Authentication auth) {
		Collection<? extends GrantedAuthority> roles = auth.getAuthorities();
		List<String> profils = new ArrayList<String>();
		for (GrantedAuthority role : roles) {
			
			String profil = role.getAuthority();
			profils.add(profil);
		}
		return profils;
		
		
	}

}
