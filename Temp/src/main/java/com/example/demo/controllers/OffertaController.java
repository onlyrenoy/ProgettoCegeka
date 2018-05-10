package com.example.demo.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entities.CandidatoLivello;
import com.example.demo.entities.Competenze;
import com.example.demo.entities.Offerta;
import com.example.demo.services.OffertaService;


@RestController
@RequestMapping(path="/offerta")
public class OffertaController {
	
	@Autowired
	private OffertaService offertaService;
	
	@GetMapping(path="/match")
	public List<CandidatoLivello> matchOfferta(){
		
		return offertaService.matchOfferta(1);
		
	}
	
	@PostMapping(path="/create")
	public ResponseEntity<Object> creaOfferta(@RequestBody Offerta off){
		
		Offerta offerta = offertaService.salvaOfferta(off);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(offerta.getIdOfferta()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(path="/stato")
	public List<Offerta> offertaPerStato(){
		return offertaService.offertaPerStato("aperto");
	}
	
	@GetMapping(path="/competenze")
	public List<Competenze> competenzeOfferta(int idOfferta){
		return offertaService.listaCompetenze(idOfferta);
	}
	
	@GetMapping(path="/offerte/{id}")
	public Offerta findById(@PathVariable("id") int idOfferta){
		return offertaService.offertaPerId(idOfferta);
		
	}
	
	@GetMapping(path="/match/{id}")
	public List<CandidatoLivello> matchOfferta(@PathVariable("id") int idOfferta){
		return offertaService.matchOfferta(idOfferta);
	}
	
	@GetMapping(path="/matchN/{id}/{pageSize}")
	public List<CandidatoLivello> matchOfferta(@PathVariable("id") int idOfferta,@PathVariable("pageSize") int pageSize){
		return offertaService.topNMatch(idOfferta, pageSize);
	}

}
