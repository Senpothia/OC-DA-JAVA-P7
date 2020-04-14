package com.formation.projet7.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.projet7.model.Emprunt;
import com.formation.projet7.model.User;

public interface EmpruntRepo extends JpaRepository<Emprunt, Integer> {

	List<Emprunt> findByEmprunteur(User user);

}
