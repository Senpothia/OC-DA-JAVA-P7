package com.formation.projet7.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.formation.projet7.model.Utilisateur;

@Repository
public interface UserRepo extends JpaRepository<Utilisateur, Integer> {
	
	@Query(value = "select * from user u where u.nom like ?1 or u.prenom like ?1", nativeQuery = true)
	Utilisateur findByIdentity(String string);

	Utilisateur findByUsername(String email);

}
