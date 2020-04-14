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

}
