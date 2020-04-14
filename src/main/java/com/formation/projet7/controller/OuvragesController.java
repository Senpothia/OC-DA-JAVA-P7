package com.formation.projet7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.projet7.model.Ouvrage;
import com.formation.projet7.service.jpa.OuvrageService;

@RestController
@RequestMapping("/biblio")
public class OuvragesController {
	
	@Autowired
	OuvrageService ouvrageService;
	
	@GetMapping("/ouvrage/liste")
	public List<Ouvrage> tousLesOuvrages(){
		
		List<Ouvrage> ouvrages = ouvrageService.listerOuvrages();
 		return ouvrages; 
	}

}
