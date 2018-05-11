package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Candidato;
import com.example.demo.entities.Competenze;
import com.example.demo.services.CandidatoCompetenzeService;

@RestController
@RequestMapping(path="/candidatoCompetenze")
public class CandidatoCompetenzeController
{
	@Autowired
	private CandidatoCompetenzeService candidatoCompetenzeService;
	
	@PostMapping(path="/nuovacompetenza")
	public String creaCompetenzaCandidato(@RequestBody Candidato candidato, @RequestBody Competenze competenza, @Param("livellodichiarati") int livelloDichiarato)
	{
		return this.candidatoCompetenzeService.creaCompetenzaCandidato(candidato, competenza, livelloDichiarato);
	}

}
