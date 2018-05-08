package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.Candidato;
import com.example.demo.services.CandidatoService;

@Controller
@RequestMapping(path="/candidato")
public class CandidatoController 
{
	@Autowired
	private CandidatoService candidatoService;
	
	@GetMapping(path="/salva")
	public @ResponseBody Candidato salva()
	{
		Candidato c =  candidatoService.creaCandidato("Zlatan", "Ibrahimovic", 34);
		return c;
	}
	
	@GetMapping(path="/competenze")
	public @ResponseBody List<Candidato> listaCandidati()
	{
		List<Candidato> c = candidatoService.findByCompetenze("java");
		return c;
	}
	
}
