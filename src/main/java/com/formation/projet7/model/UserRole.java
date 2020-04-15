package com.formation.projet7.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class UserRole {
	
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "username")
	private Utilisateur user;
	
	private String role;
	

	public UserRole() {
		
	}

	
	public UserRole(Integer id, Utilisateur user, String role) {
		super();
		this.id = id;
		this.user = user;
		this.role = role;
	}


	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Utilisateur getUser() {
		return user;
	}



	public void setUser(Utilisateur user) {
		this.user = user;
	}



	public void setRole(String role) {
		this.role = role;
	}


	public String getRole() {
		// TODO Auto-generated method stub
		return null;
	}

}
