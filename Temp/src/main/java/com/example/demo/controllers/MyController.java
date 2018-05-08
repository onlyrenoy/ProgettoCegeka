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
@RequestMapping(path="/go")
public class MyController {
	
	@Autowired
	private CandidatoService candService;
	
	@GetMapping(path="/home")
	public  @ResponseBody  String go()
	{
		return "hello";
	}
	

	

}
