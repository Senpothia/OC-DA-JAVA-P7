package com.formation.projet7.service.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.formation.projet7.model.FormCompte;
import com.formation.projet7.model.Profil;
import com.formation.projet7.model.Utilisateur;
import com.formation.projet7.repository.ProfilRepo;
import com.formation.projet7.repository.UserRepo;
import com.formation.projet7.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	ProfilService profilService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public List<Utilisateur> listerUsers() {
		
		List<Utilisateur> users = userRepo.findAll();
		return users;
	}

	@Override
	public Utilisateur obtenirUserParId(Integer id) {
		
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
	public void ajouterUser(Utilisateur user, String role) {
		user.setEnabled(true);
		String password = user.getPassword();
		
		user.setPassword(passwordEncoder.encode(password));
		
		Profil profil = profilService.obtenirProfil(role);
		List<Profil> profils = user.getProfils();
		if (profils == null) {
			
			profils = new ArrayList<Profil>();
			profils.add(profil);
		}else {
			
			profils.add(profil);
		}
		
		user.setProfils(profils);
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

	@Override
	public FormCompte obtenirFormCompte(Utilisateur utilisateur) {
		
		FormCompte formCompte = new FormCompte();
		formCompte.setPrenom(utilisateur.getPrenom());
		formCompte.setNom(utilisateur.getNom());
		formCompte.setUsername(utilisateur.getUsername());
		
		return formCompte;
	}

	@Override
	public void ajouterRoleUser(Utilisateur user, String role) {
		
		List<Profil> roles = user.getProfils();
		Profil profil = profilService.obtenirProfil(role);
		roles.add(profil);
		userRepo.save(user);
		
	}
	

}
