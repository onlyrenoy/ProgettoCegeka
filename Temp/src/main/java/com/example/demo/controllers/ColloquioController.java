package com.example.demo.controllers;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.Candidato;
import com.example.demo.entities.Colloquio;
import com.example.demo.entities.Intervistatore;
import com.example.demo.entities.Offerta;
import com.example.demo.services.CandidatoService;
import com.example.demo.services.ColloquioService;

@Controller
@RequestMapping(path="/go")
public class ColloquioController {
	
	@Autowired
	private CandidatoService candService;
	
	@Autowired
	private ColloquioService colloquioService ;
	
	@GetMapping(path="/creaColloquio")
	public @ResponseBody String creaColloquio() {
		
		Date data = new Date(118, 1, 23);
		colloquioService.creaColloquio(data, "R&D", 3, 4, 2);
		
		return "colloquio salvato ";
		
		
	}
	
	@GetMapping(path="/findByCandidato")
	public @ResponseBody List<Colloquio> findByNomeCandidato(){
		
		List<Colloquio> c = colloquioService.findColloquioNomeCandidato("emanuel");
		return c;
	}
	
	@GetMapping(path="/findByIntervistatore")
	public @ResponseBody List<Colloquio> findByNomeIntervistatore(){
		
		List<Colloquio> c = colloquioService.findColloquioNomeIntervistatore("gujohu");
		return c;
	}
	
	@GetMapping(path="/findByOfferta")
	public @ResponseBody List<Colloquio> findByRuoloOfferta(){
		List<Colloquio> c = colloquioService.findColloquioRuoloOfferta("INFORMATICO");
		return c;
	}
	
	@GetMapping(path="/removeColloquioId")
	public @ResponseBody String rimuoviColloquioId(){
		
	
		colloquioService.removeById(1);
		return "rimosso con successo";
		
	}
	
	

}
