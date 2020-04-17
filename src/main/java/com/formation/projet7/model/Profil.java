package com.formation.projet7.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Profil {
	
	@Id
	@GeneratedValue() // auto_increment MySQL
	private Integer id;
	private String perfil;
	
	public Profil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profil(Integer id, String perfil) {
		super();
		this.id = id;
		this.perfil = perfil;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	

	
}
