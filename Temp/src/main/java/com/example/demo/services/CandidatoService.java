package com.example.demo.services;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Candidato;
import com.example.demo.entities.CandidatoCompetenze;
import com.example.demo.entities.Competenze;
import com.example.demo.interfaces.CandidatoRepository;
import com.example.demo.interfaces.CompetenzeRepository;

@Service
public class CandidatoService 
{
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@Autowired
	private CompetenzeRepository competenzeRepository;
	
	// creazione di un candidato passando un oggetto candidato
	public Candidato creaCandidato(Candidato candidato)
	{
		return this.candidatoRepository.save(candidato);
	}
	
	// creazione di un candidato passando un oggetto candidato e una competenza
	public Candidato creaCandidato(Candidato candidato,Competenze competenza)
	{
		CandidatoCompetenze c = new CandidatoCompetenze();
		c.setCompetenze(competenza);
		c.setLivelloDichiarato(4);
		candidato.getCandidatoCompetenze().add(c);
		return this.candidatoRepository.save(candidato);
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
	
	public List<Candidato> findByNameContaining(String nome)
	{
		return this.candidatoRepository.findByNomeContainingOrderByNomeAsc(nome);
	}

	public List<Candidato> findAll() {
		return  this.candidatoRepository.findAll();
	}
	
	
	
}
