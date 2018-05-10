package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.IntervistatoreService;

@RestController
@RequestMapping(path="/inter")
public class IntervistatoreController {
	
	@Autowired
	private IntervistatoreService intervistatoreService;
	
	
	@PostMapping(path="/creaIntervistatore")
	public String creaIntervistatore() {
		
		intervistatoreService.creaIntervistatore("Samy", "Johnson", "TecnicoDip", "tecnico");
		return "intervistatore creato con successo";
		
		
	}
	

}
