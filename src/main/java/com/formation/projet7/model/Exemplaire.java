package com.formation.projet7.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Exemplaire {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Ouvrage ouvrage;
	private boolean disponible;
	private boolean actif;
	
	public Exemplaire() {
		
	}

	public Exemplaire(Integer id, Ouvrage ouvrage, boolean disponible, boolean actif) {
		super();
		this.id = id;
		this.ouvrage = ouvrage;
		this.disponible = disponible;
		this.actif = actif;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Ouvrage getOuvrage() {
		return ouvrage;
	}

	public void setOuvrage(Ouvrage ouvrage) {
		this.ouvrage = ouvrage;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}
	

}
