package com.formation.projet7.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.projet7.model.Emprunt;
import com.formation.projet7.model.Utilisateur;

@Repository
public interface EmpruntRepo extends JpaRepository<Emprunt, Integer> {

	List<Emprunt> findByEmprunteur(Utilisateur utilisateur);

}
