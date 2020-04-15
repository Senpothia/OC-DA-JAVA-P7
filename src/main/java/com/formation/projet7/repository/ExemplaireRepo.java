package com.formation.projet7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.projet7.model.Exemplaire;
@Repository
public interface ExemplaireRepo extends JpaRepository<Exemplaire, Integer> {

}
