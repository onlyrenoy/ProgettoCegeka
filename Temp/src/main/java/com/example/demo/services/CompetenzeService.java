package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Competenze;
import com.example.demo.interfaces.CompetenzeRepository;

@Service
public class CompetenzeService {
	
	@Autowired
	private CompetenzeRepository competenzeRepository;
	
	public void creaCompetenza(Competenze competenza)
	{
		this.competenzeRepository.save(competenza);
	}
	
	public String creaCompetenze(String categoria, String nome)
	{
		boolean check = false;
		String log = "";
		
		List<Competenze> competenze = competenzeRepository.findAll();
		for(Competenze competenza : competenze) {
			if(competenza.getCategoria().equals(categoria) && competenza.getNome().equals(nome)) {
				check = true;
			
			}
		}
		
		if(check==false) {
			Competenze competenza = new Competenze();
			competenza.setCategoria(categoria);
			competenza.setNome(nome);
			
			this.competenzeRepository.save(competenza);
			
			log = "competenza inserita";
		}else {
			log = "competenza già presente";
		}
		return log;
	}
	

		public void rimuoviCompetenza(Competenze competenza)
		{
			this.competenzeRepository.delete(competenza);
		}
		
		
		public String rimuoviCompetenza(int id)
		{
			String stato;
			if(competenzeRepository.findById(id) != null)
			{
			this.competenzeRepository.deleteById(id);
			stato="competenza cancellata!";
			}
			else 
			{
				stato = "competenza non esistente";
			}
			return stato;
		}
		
		public List<Competenze> listPerNome(String nome)
		{
			return this.competenzeRepository.findByNome(nome);
		}
		
		public List<Competenze> listPerCategoria(String categoria)
		{
			return this.competenzeRepository.findByCategoria(categoria);
		}
		
		public void aggiornaCategoria(String categoria,int id) {
			
			Optional<Competenze> competenze = competenzeRepository.findById(id);
			competenze.get().setCategoria(categoria);
			competenzeRepository.save(competenze.get());
			
		}
		
        public void aggiornaNome(String nome,int id) {
			
			Optional<Competenze> competenze = competenzeRepository.findById(id);
			competenze.get().setNome(nome);
			competenzeRepository.save(competenze.get());
			
		}
		
	
}
