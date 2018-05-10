package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Candidato;
import com.example.demo.services.CandidatoService;

@RestController
@RequestMapping(path="/candidato")
public class CandidatoController 
{
	@Autowired
	private CandidatoService candidatoService;
	
	
	@PostMapping(path="/salva")
	public @ResponseBody Candidato salva(@Param("nome") String nome, @Param("cognome") String cognome, @Param("eta") int eta )
	{
		Candidato c =  candidatoService.creaCandidato(nome, cognome, eta);
		return c;
	}
	
	@GetMapping(path="/competenze")
	public @ResponseBody List<Candidato> listaCandidati(@Param("nome") String nome)
	{
		List<Candidato> c = candidatoService.findByCompetenze(nome);
		return c;
	}
	
	
	
	//rimozione di un candidato dal database
	@DeleteMapping(path="/rimuovicandidato")
	public @ResponseBody String rimuoviCandidato(@Param("id") int id)
	{
		 return candidatoService.rimuoviCandidato(id);
		
	}
	
	@GetMapping(path="/candidatiPerNome")
	public @ResponseBody List<Candidato> listaPerNome(@Param("nome") String nome)
	{
		List<Candidato> c = candidatoService.findByName(nome);
		return c;
	}
	
	@GetMapping(path="/candidatiPerCognome")
	public @ResponseBody List<Candidato> listaPerCognome(@Param("cognome") String cognome)
	{
		List<Candidato> c = candidatoService.findBySurname(cognome);
		return c;
	}
	
	
	
}
