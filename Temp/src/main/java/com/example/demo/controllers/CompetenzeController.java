package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.Competenze;
import com.example.demo.services.CompetenzeService;


@Controller
@RequestMapping(path="/co")
public class CompetenzeController {
	
	@Autowired
	private CompetenzeService competenzeService;
	
	@GetMapping(path="/creaCompetenza")
	public @ResponseBody String creacompetenza() {
		return competenzeService.creaCompetenze("info","CSS");	
	}
	
	
	@GetMapping(path="/aggiornaCategoriaCompetenze")
	public @ResponseBody String aggiornaCategoriaCompetenze() {
		competenzeService.aggiornaCategoria("info", 1);
		return "Categoria aggiornata";
	
	}
	
	@GetMapping(path="/aggiornaNomeCompetenze")
	public @ResponseBody String aggiornaNomeCompetenze() {
		competenzeService.aggiornaNome("html", 1);
		return "Nome aggiornato";
	
	}
	
	@GetMapping(path="/deleteCompetenza")
	public @ResponseBody String DeleteCompetenza() {
		
		competenzeService.rimuoviCompetenza(2);
		return "competenza rimossa";
		
	}
	@GetMapping(path="/ricercaPerNome")
	public @ResponseBody List<Competenze> ricercaPerNome(){
		
		return competenzeService.listPerNome("java");
		
	}
	
	@GetMapping(path="/ricercaPerCategoria")
	public @ResponseBody List<Competenze> ricercaPerCategoria(){
		
		return competenzeService.listPerCategoria("info");
		
	}
	
	
	

}
