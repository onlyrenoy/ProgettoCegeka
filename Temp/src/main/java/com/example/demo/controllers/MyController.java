package com.example.demo.controllers;

import java.util.ArrayList;
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
import com.example.demo.service.CandidatoService;
import com.example.demo.services.ColloquioService;

@Controller
@RequestMapping(path="/go")
public class MyController {
	
	@Autowired
	private CandidatoService candService;
	
	@Autowired
	private ColloquioService colloquioService ;
	
	@GetMapping(path="/home")
	public  @ResponseBody  String go()
	{
		return "hello";
	}
	
	@GetMapping(path="/salva")
	public @ResponseBody String salva()
	{
		Candidato c = new Candidato();
		c.setCognome("biba");
		c.setEta(23);
		c.setNome("eddi");
		
		candService.save(c);	
		
		return "dati salvati";
	}
	
	
	@GetMapping(path="/creaColloquio")
	public @ResponseBody String creaColloquio() {
		
		Date data = new Date(2018, 5, 8);
		Intervistatore intervistatore = new Intervistatore ();
		Offerta offerta = new Offerta ();
		Candidato candidato = new Candidato ();
//		colloquioService.creaColloquio(data, "R&D", intervistatore, candidato, offerta);
		
		return "colloquio salvato ";
		
		
	}
	
	@GetMapping(path="/findByCandidato")
	public @ResponseBody List<Colloquio> findByNomeCandidato(){
		
		List<Colloquio> c = colloquioService.findColloquioNomeCandidato("eddi");
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
	
	
	

}
