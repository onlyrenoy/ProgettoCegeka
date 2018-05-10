package com.example.demo.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Candidato;
import com.example.demo.entities.CandidatoCompetenze;
import com.example.demo.entities.CandidatoLivello;
import com.example.demo.entities.Competenze;
import com.example.demo.entities.Offerta;
import com.example.demo.interfaces.CandidatoRepository;
import com.example.demo.interfaces.OffertaRepository;

@Service
public class OffertaService {

	@Autowired
	private OffertaRepository offertaRepository;

	@Autowired
	private CandidatoRepository candidatoRepository;
	
	public List<CandidatoLivello> matchOfferta(int idOfferta) {

		Optional<Offerta> offerta = offertaRepository.findById(idOfferta);
		List<Competenze> competenzeRichieste = offerta.get().getCompetenze();
		List<Candidato> candidati = candidatoRepository.findAll();
		List<CandidatoLivello> lista = new ArrayList<CandidatoLivello>();
		for (Candidato candidato : candidati) {
			List<CandidatoCompetenze> candidatoCompetenze = candidato.getCandidatoCompetenze();
			CandidatoLivello cl = new CandidatoLivello();
			cl.setCandidato(candidato);
			for (CandidatoCompetenze c : candidatoCompetenze) {
				for (Competenze co : competenzeRichieste) {
					if (c.getCompetenze().getNome().equals(co.getNome())) {
						cl.setContatore(cl.getContatore() + 1);
					}
				}
			}
			if(cl.getContatore()>0) {
				lista.add(cl);
			}
		}
		lista.sort(Comparator.comparing(CandidatoLivello::getContatore).reversed());
		return lista;
	}
	
	

}
