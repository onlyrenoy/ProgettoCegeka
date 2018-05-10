package com.example.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.interfaces.CandidatoCompetenzeRepository;

@Service
public class CandidatoCompetenzeService 
{
	@Autowired
	private CandidatoCompetenzeRepository candidatoCompetenzeRepository;


}
