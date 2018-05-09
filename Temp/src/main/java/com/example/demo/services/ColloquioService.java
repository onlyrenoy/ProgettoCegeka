package com.example.demo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Candidato;
import com.example.demo.entities.Colloquio;
import com.example.demo.entities.Intervistatore;
import com.example.demo.entities.Offerta;
import com.example.demo.interfaces.CandidatoRepository;
import com.example.demo.interfaces.ColloquioRepository;
import com.example.demo.interfaces.IntervistatoreRepository;
import com.example.demo.interfaces.OffertaRepository;

@Service
public class ColloquioService {
	
	@Autowired
	private ColloquioRepository colloquioRepository;
	
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@Autowired
	private IntervistatoreRepository intervistatoreRepository;
	
	@Autowired
	private OffertaRepository offertaRepository;
	
	
	// TO FIX
	public void creaColloquio(Date data,String dipartimento,int id_intervistatore,int id_candidato,int id_offerta) {
		
		Colloquio c = new Colloquio();
		c.setDataOra(data);
		Optional<Intervistatore> intervistatore = intervistatoreRepository.findById(id_intervistatore);
		Optional<Offerta> offerta = offertaRepository.findById(id_offerta);
		Optional<Candidato> candidato = candidatoRepository.findById(id_candidato);
		c.setIntervistatore(intervistatore.get());
		c.setCandidato(candidato.get());
		c.setOfferta(offerta.get());
		c.setDipartimento(dipartimento);
		c.setStatoColloquio("PIANIFICATO");
		colloquioRepository.save(c);
	}
	
	public List<Colloquio> findColloquioNomeCandidato(String nome) {

			return colloquioRepository.findByCandidatoNome(nome);
		
	}
	
	public List<Colloquio> findColloquioNomeIntervistatore(String nome) {

		return colloquioRepository.findByIntervistatoreNome(nome);
	
    }
	
	public List<Colloquio> findColloquioRuoloOfferta(String ruolo){
		
		return colloquioRepository.findByOffertaRuolo(ruolo);
	}
	
	public void removeById(int id) {
		
		if(colloquioRepository.findById(id) != null) {			
			colloquioRepository.deleteById(id);
		}
	}
	
	

}
