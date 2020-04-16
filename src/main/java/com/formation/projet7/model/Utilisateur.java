package com.formation.projet7.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Utilisateur {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String nom;
	private String prenom;
	private String username;
	private String password;
	private boolean enabled;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "UserProfil", // table intermediaire
			joinColumns = @JoinColumn(name = "idUser"), // foreignKey de la table de UserProfil
			inverseJoinColumns = @JoinColumn(name = "idProfil") // foreignKey de la table de UserProfil
	)
	private List<Profil> profils;
	
	@JsonIgnore
	@OneToMany(mappedBy="emprunteur")
	private List<Emprunt> emprunts;
	
	
	private static final long serialVersionUID = 1L;


	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Utilisateur(Integer id, String nom, String prenom, String username, String password, boolean enabled,
			List<Profil> profils, List<Emprunt> emprunts) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.profils = profils;
		this.emprunts = emprunts;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public List<Profil> getProfils() {
		return profils;
	}


	public void setProfils(List<Profil> profils) {
		this.profils = profils;
	}


	public List<Emprunt> getEmprunts() {
		return emprunts;
	}


	public void setEmprunts(List<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

}
