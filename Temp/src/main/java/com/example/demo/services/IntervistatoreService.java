package com.example.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Intervistatore;
import com.example.demo.interfaces.ColloquioRepository;
import com.example.demo.interfaces.IntervistatoreRepository;

@Service
public class IntervistatoreService {
	
	@Autowired
	private IntervistatoreRepository intervistatoreRepository;
	
	public void creaIntervistatore(String nome,String cognome,String dipartimento,String posizioneDipartimento) {
		Intervistatore intervistatore = new Intervistatore();
		intervistatore.setNome(nome);
		intervistatore.setCognome(cognome);
		intervistatore.setDipartimento(dipartimento);
		intervistatore.setPosizioneNelDipartimento(posizioneDipartimento);
		intervistatoreRepository.save(intervistatore);
	}

}
