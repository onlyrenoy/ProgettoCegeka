package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.services.CandidatoCompetenzeService;

@Controller
@RequestMapping(path="/candidatoCompetenze")
public class CandidatoCompetenzeController
{
	@Autowired
	private CandidatoCompetenzeService candidatoCompetenzeService;

}
