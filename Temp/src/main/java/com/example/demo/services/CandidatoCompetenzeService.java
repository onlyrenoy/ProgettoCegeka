package com.example.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Candidato;
import com.example.demo.entities.CandidatoCompetenze;
import com.example.demo.entities.Competenze;
import com.example.demo.interfaces.CandidatoCompetenzeRepository;


@Service
public class CandidatoCompetenzeService 
{
	@Autowired
	private CandidatoCompetenzeRepository candidatoCompetenzeRepository;
	
	

	public String creaCompetenzaCandidato(Candidato candidato, Competenze competenza, int livelloDichiarato)
	{
		String ritorno= "";
		for(CandidatoCompetenze cc : candidato.getCandidatoCompetenze())
		{
			if(cc.getCandidati().getIdCandidato()==(candidato.getIdCandidato()) && cc.getCompetenze().getIdCompetenze()==(competenza.getIdCompetenze()))
			{
				ritorno = "il candidato ha già quella competenza associata";
			}
			else
			{
				CandidatoCompetenze candidatoCompetenze = new CandidatoCompetenze();
				candidatoCompetenze.setCandidati(candidato);
				candidatoCompetenze.setCompetenze(competenza);
				candidatoCompetenze.setLivelloDichiarato(livelloDichiarato);
				
				candidatoCompetenzeRepository.save(candidatoCompetenze);
				
				ritorno ="competenza associata al candidato correttamente";
			}
		}
		return ritorno;
	}

}
