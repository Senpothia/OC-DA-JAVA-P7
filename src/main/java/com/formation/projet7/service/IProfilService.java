package com.formation.projet7.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.formation.projet7.model.Profil;

public interface IProfilService {
	
	void creerProfil(String role);
	
}
