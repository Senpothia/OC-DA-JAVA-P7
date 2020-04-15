package com.formation.projet7.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.projet7.model.Ouvrage;

@Repository
public interface OuvrageRepo extends JpaRepository<Ouvrage, Integer> {

}
