package com.example.demo.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Candidato;

@Service
public class CandidatoService 
{
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	public void save(Candidato candidato)
	{
		this.candidatoRepository.save(candidato);
	}
}
