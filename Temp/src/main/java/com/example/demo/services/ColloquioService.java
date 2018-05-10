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
		Optional<Intervistatore> intervistatoreOpt = intervistatoreRepository.findById(id_intervistatore);
		Optional<Offerta> offertaOpt = offertaRepository.findById(id_offerta);
		Optional<Candidato> candidatoOpt = candidatoRepository.findById(id_candidato);
		c.setIntervistatore(intervistatoreOpt.get());
		c.setCandidato(candidatoOpt.get());
		c.setOfferta(offertaOpt.get());
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
	
	public void removeByNomeCandidato(String nome) {
		List<Colloquio> colloqui = colloquioRepository.findByCandidatoNome(nome);
		if(colloqui != null) {
			colloquioRepository.deleteInBatch(colloqui);
		}
	}
	
	public void aggiornaFeedbackStato(String feedback,String stato,int id) {
		Optional<Colloquio> colloquio = colloquioRepository.findById(id);
		colloquio.get().setFeedback(feedback);
		colloquio.get().setStatoColloquio(stato);
		colloquioRepository.save(colloquio.get());
	}
	
	public void aggiornaFeedback(String feedback,int id) {
		Optional<Colloquio> colloquio = colloquioRepository.findById(id);
		colloquio.get().setFeedback(feedback);
		colloquioRepository.save(colloquio.get());
	}
	
	public void aggiornaStato(String stato,int id) {
		Optional<Colloquio> colloquio = colloquioRepository.findById(id);
		colloquio.get().setStatoColloquio(stato);
		colloquioRepository.save(colloquio.get());
	}
	
	public void cambiaIntervistatore(int idColloquio,int idIntervistatore) {
		Optional<Colloquio> colloquio = colloquioRepository.findById(idColloquio);
		Optional<Intervistatore> intervistatore = intervistatoreRepository.findById(idIntervistatore);
		colloquio.get().setIntervistatore(intervistatore.get());
		colloquioRepository.save(colloquio.get());

	}
	

}
