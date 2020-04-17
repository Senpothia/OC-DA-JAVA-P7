package com.formation.projet7.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.projet7.model.Profil;

public interface ProfilRepo extends JpaRepository<Profil, Integer> {

	Profil getByPerfil(String string);

	
}
