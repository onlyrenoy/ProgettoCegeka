package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Competenze;
import com.example.demo.interfaces.CompetenzeRepository;

public class CompetenzeService {
	
	@Autowired
	private CompetenzeRepository competenzeRepository;
	
	public Competenze creaCompetenza(Competenze competenza)
	{
		return this.competenzeRepository.save(competenza);
	}
	
	public Competenze creaCompetenze(String categoria, String nome)
	{
		Competenze competenza = new Competenze();
		competenza.setCategoria(categoria);
		competenza.setNome(nome);
		
		return this.competenzeRepository.save(competenza);
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
		
	
}
