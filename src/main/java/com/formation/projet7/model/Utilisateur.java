package com.formation.projet7.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"username"})})
public class Utilisateur implements Serializable {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String nom;
	private String prenom;
	private String username;
	private String password;
	
	@JsonIgnore
	@OneToMany(mappedBy="emprunteur")
	private List<Emprunt> emprunts;
	
	
	private static final long serialVersionUID = 1L;
	
	public Utilisateur() {
		
	}

	public Utilisateur(Integer id, String nom, String prenom, String username, String password,
			List<Emprunt> emprunts) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
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

	public List<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(List<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

	

}
