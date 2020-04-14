package com.formation.projet7.service;

import java.util.List;

import com.formation.projet7.model.Emprunt;
import com.formation.projet7.model.Exemplaire;
import com.formation.projet7.model.Ouvrage;
import com.formation.projet7.model.User;

public interface IEmpruntService {
	
	List<Emprunt> listerUserEmprunt(User user);
	List<Exemplaire> listerOuvrageEmprunts(Ouvrage ouvrage);

}
