package com.azienda.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/main")
public class CandidatoController {
	
	@GetMapping(path="/lista")
	public @ResponseBody String lista() {
		return "helloworld";
	}

}
