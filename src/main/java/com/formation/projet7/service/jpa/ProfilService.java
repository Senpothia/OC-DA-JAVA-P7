package com.formation.projet7.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import com.formation.projet7.model.Profil;
import com.formation.projet7.repository.ProfilRepo;
import com.formation.projet7.service.IProfilService;

public class ProfilService implements IProfilService {

	@Autowired
	ProfilRepo profilRepo;
	
	@Override
	public void creerProfil(String role) {
		
		Profil profil = new Profil();
		profil.setPerfil(role);
		profilRepo.save(profil);
		
	}

}
