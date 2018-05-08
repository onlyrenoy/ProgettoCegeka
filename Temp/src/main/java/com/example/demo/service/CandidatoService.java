package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Candidato;
import com.example.demo.interfaces.CandidatoRepository;

@Service
public class CandidatoService 
{
	@Autowired    //si usa per caricare un beans che si trova nel contesto di xml
	private CandidatoRepository candidatoRepository;
	
	public void save(Candidato candidato)
	{
		this.candidatoRepository.save(candidato);
	}
}
