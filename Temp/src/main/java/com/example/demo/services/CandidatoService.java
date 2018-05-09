package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Candidato;
import com.example.demo.entities.CanditatoCompetenze;
import com.example.demo.interfaces.CandidatoRepository;

@Service
public class CandidatoService 
{
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	// creazione di un candidato passando un oggetto candidato
	public void creaCandidato(Candidato candidato)
	{
		this.candidatoRepository.save(candidato);
	}
	
	//creazione di un candidato passando gli argomenti da modificare
	public Candidato creaCandidato(String nome, String cognome, int eta)
	{
		Candidato c = new Candidato();
		c.setNome(nome);
		c.setCognome(cognome);
		c.setEta(eta);
		
		return this.candidatoRepository.save(c);
		
	}
	
	//rimozione di un candidato passando un oggetto candidato
	public void rimuoviCandidato(Candidato candidato)
	{
		this.candidatoRepository.delete(candidato);
	}
	
	//rimozione candidato tramite id
	public String rimuoviCandidato(int id)
	{
		String stato;
		if(candidatoRepository.findById(id) != null)
		{
		this.candidatoRepository.deleteById(id);
		stato="utente cancellato!";
		}
		else 
		{
			stato = "utente non esiste";
		}
		return stato;
	}
	
	//aggiornamento competenze candidato
	public void aggiornaCompetenzeCandidato(Candidato candidato, CanditatoCompetenze candidatoCompetenze)
	{
		Candidato c = candidatoRepository.getOne(candidato.getIdCandidato());
		c.getCandidatoCompetenze().add(candidatoCompetenze);
		
		this.candidatoRepository.save(c);
		
	}
	
	// tutti i candidati tramite il nome
	public List<Candidato> findByName(String name)
	{
		return this.candidatoRepository.findByNome(name);
		
	}
	
	// tutti i candidati cognome
	public List<Candidato> findBySurname(String surname)
	{
		return this.candidatoRepository.findByCognome(surname);
	}
	
	// tutti i candidati con una determinata competenza
	public List<Candidato> findByCompetenze(String competenza)
	{
		return this.candidatoRepository.findBySkill(competenza);
	}
	
	
	
	
	

	
	
	
	
}
