package com.formation.projet7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.formation.projet7.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	@Query(value = "select * from user u where u.nom like ?1 or u.prenom like ?1", nativeQuery = true)
	User findByIdentity(String string);

	User findByUsername(String email);

}
