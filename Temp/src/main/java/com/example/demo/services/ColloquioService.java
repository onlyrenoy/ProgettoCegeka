package com.example.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Candidato;
import com.example.demo.entities.Colloquio;
import com.example.demo.entities.Intervistatore;
import com.example.demo.entities.Offerta;
import com.example.demo.interfaces.ColloquioRepository;

@Service
public class ColloquioService {
	
	@Autowired
	private ColloquioRepository colloquioRepository;
	
	// TO FIX
	public void creaColloquio(Date data,String dipartimento,int id_intervistatore,int id_candidato,int id_offerta) {
		
		Colloquio c = new Colloquio();
		c.setDataOra(data);
		Optional <Colloquio> colloquio = colloquioRepository.findById((long) id_intervistatore);
//		c.setIntervistatore(intervistatore);
//		c.setCandidato(candidato);
//		c.setOfferta(offerta);
//		c.setDipartimento(dipartimento);
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
	
	

}
