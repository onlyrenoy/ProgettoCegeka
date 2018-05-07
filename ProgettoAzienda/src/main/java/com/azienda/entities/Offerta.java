package com.azienda.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

public class Offerta {
	
	private int idOfferta;
	
	private String ruolo;
	
	@ManyToMany(mappedBy="offerte")
	@JoinColumn(nullable=false)
	private List<Competenze> competenze;
	
	private String statoOfferta;
	
	private String dipartimento;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "offerta")
	List<Colloquio> colloqui;
	
	public Offerta() {
		
	}
	

	public int getIdOfferta() {
		return idOfferta;
	}



	public void setIdOfferta(int idOfferta) {
		this.idOfferta = idOfferta;
	}



	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public List<Competenze> getCompetenze() {
		return competenze;
	}

	public void setCompetenze(List<Competenze> competenze) {
		this.competenze = competenze;
	}

	public String getStatoOfferta() {
		return statoOfferta;
	}

	public void setStatoOfferta(String statoOfferta) {
		this.statoOfferta = statoOfferta;
	}

	public String getDipartimento() {
		return dipartimento;
	}

	public void setDipartimento(String dipartimento) {
		this.dipartimento = dipartimento;
	}

	public List<Colloquio> getColloqui() {
		return colloqui;
	}

	public void setColloqui(List<Colloquio> colloqui) {
		this.colloqui = colloqui;
	}
	
	
	
	

}
