package com.formation.projet7.model;

import java.util.Date;

public class Emprunt {
	
	private Integer id;
	private Exemplaire exemplaire;
	private User emprunteur;
	private Date debut;
	private Date fin;
	private boolean prolongation; 
	private boolean actif;
	
	public Emprunt() {
		
	}

	public Emprunt(Integer id, Exemplaire exemplaire, User emprunteur, Date debut, Date fin, boolean prolongation,
			boolean actif) {
		super();
		this.id = id;
		this.exemplaire = exemplaire;
		this.emprunteur = emprunteur;
		this.debut = debut;
		this.fin = fin;
		this.prolongation = prolongation;
		this.actif = actif;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Exemplaire getExemplaire() {
		return exemplaire;
	}

	public void setExemplaire(Exemplaire exemplaire) {
		this.exemplaire = exemplaire;
	}

	public User getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(User emprunteur) {
		this.emprunteur = emprunteur;
	}

	public Date getDebut() {
		return debut;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public boolean isProlongation() {
		return prolongation;
	}

	public void setProlongation(boolean prolongation) {
		this.prolongation = prolongation;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}
	
	

}
