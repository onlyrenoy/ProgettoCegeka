package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.CandidatoLivello;
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

}
