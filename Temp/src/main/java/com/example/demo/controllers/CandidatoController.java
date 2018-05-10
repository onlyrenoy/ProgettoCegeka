package com.example.demo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entities.Candidato;
import com.example.demo.services.CandidatoService;

@RestController
@RequestMapping(path="/candidato")
public class CandidatoController 
{
	@Autowired
	private CandidatoService candidatoService;
	
	
//	@PostMapping(path="/candidati")
//	public @ResponseBody Candidato salva(@Param("nome") String nome, @Param("cognome") String cognome, @Param("eta") int eta )
//	{
//		Candidato c =  candidatoService.creaCandidato(nome, cognome, eta);
//		return c;
//	}
	
	@GetMapping(path="/candidati")
	public @ResponseBody List<Candidato> tutti ()
	{
		return candidatoService.findAll();
	}
	
	@PostMapping(path="/candidati")
	public ResponseEntity<Object> salva(@RequestBody Candidato candidato)
	{
		 
		Candidato c = candidatoService.creaCandidato(candidato);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(c.getIdCandidato()).toUri();
			
			return ResponseEntity.created(location).build();
	}
	
	
	@GetMapping(path="/competenze")
	public @ResponseBody List<Candidato> listaCandidati(@Param("nome") String nome)
	{
		List<Candidato> c = candidatoService.findByCompetenze(nome);
		return c;
	}
	
	
	
	//rimozione di un candidato dal database
	@DeleteMapping(path="/candidati/{id}")
	public @ResponseBody String rimuoviCandidato(@PathVariable("id") int id)
	{
		 return candidatoService.rimuoviCandidato(id);
		
	}
	
	@GetMapping(path="/nome")
	public @ResponseBody List<Candidato> listaPerNome(@Param("nome") String nome)
	{
		List<Candidato> c = candidatoService.findByName(nome);
		return c;
	}
	
	@GetMapping(path="/candidati/{cognome}")
	public @ResponseBody List<Candidato> listaPerCognome(@PathVariable("cognome") String cognome)
	{
		List<Candidato> c = candidatoService.findBySurname(cognome);
		return c;
	}
	
	@GetMapping(path="/lettereNome")
	public @ResponseBody List<Candidato> lista(@Param("nome") String nome)
	{
		List<Candidato> c = candidatoService.findByNameContaining(nome);
		return c;
	}
	
	
	
}
