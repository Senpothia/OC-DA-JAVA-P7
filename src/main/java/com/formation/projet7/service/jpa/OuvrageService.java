package com.formation.projet7.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.projet7.model.Ouvrage;
import com.formation.projet7.repository.OuvrageRepo;
import com.formation.projet7.service.IOuvrageService;

@Service
public class OuvrageService implements IOuvrageService {

	@Autowired
	OuvrageRepo ouvrageRepo;
	
	@Override
	public List<Ouvrage> listerOuvrages() {
		
		List<Ouvrage> ouvrages = ouvrageRepo.findAll();
		return ouvrages;
	}

	@Override
	public Ouvrage obtenirOuvrage(Integer id) {
		
		Ouvrage ouvrage = ouvrageRepo.getOne(id);
		return ouvrage;
	}

	@Override
	public void ajouterOuvrage(Ouvrage ouvrage) {
		ouvrageRepo.save(ouvrage);
		
	}

	@Override
	public void modifierOuvrage(Ouvrage ouvrage) {
		ouvrageRepo.save(ouvrage);
		
	}

	@Override
	public void supprimerOuvrage(Ouvrage ouvrage) {
		ouvrageRepo.delete(ouvrage);
		
	}

}
