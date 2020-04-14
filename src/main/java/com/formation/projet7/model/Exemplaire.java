package com.formation.projet7.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Exemplaire {
	
	@Id
	@GeneratedValue
	private Integer id;
	private int numero;
	private boolean disponible;
	private boolean actif;
	
	public Exemplaire() {
		
	}

	public Exemplaire(Integer id, int numero, boolean disponible, boolean actif) {
		super();
		this.id = id;
		this.numero = numero;
		this.disponible = disponible;
		this.actif = actif;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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
