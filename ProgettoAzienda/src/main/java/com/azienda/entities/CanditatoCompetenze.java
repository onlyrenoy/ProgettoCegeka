package com.azienda.entities;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.azienda.entities.Candidato;

@Entity
public class CanditatoCompetenze {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_candidato_competenze")
	private int idCandidatoCompetenze;
	
	@Column(name="livello_dichiarato")
	private int livelloDichiarato;
	
	@Column(name="livello_effettivo")
	private int livelloEffettivo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "candidatoCompetenze")
	@JoinColumn(name = "candidadto_Id")
	private List<Candidato> candidati;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "competenzeCandidato")
	@JoinColumn(name = "competenze_Id")
	private List<Competenze> competenze;

	public int getIdCandidatoCompetenze() {
		return idCandidatoCompetenze;
	}

	public void setIdCandidatoCompetenze(int idCandidatoCompetenze) {
		this.idCandidatoCompetenze = idCandidatoCompetenze;
	}

	public int getLivelloDichiarato() {
		return livelloDichiarato;
	}

	public void setLivelloDichiarato(int livelloDichiarato) {
		this.livelloDichiarato = livelloDichiarato;
	}

	public int getLivelloEffettivo() {
		return livelloEffettivo;
	}

	public void setLivelloEffettivo(int livelloEffettivo) {
		this.livelloEffettivo = livelloEffettivo;
	}

	public List<Candidato> getCandidati() {
		return candidati;
	}

	public void setCandidati(List<Candidato> candidati) {
		this.candidati = candidati;
	}

	public List<Competenze> getCompetenze() {
		return competenze;
	}

	public void setCompetenze(List<Competenze> competenze) {
		this.competenze = competenze;
	}
	
	
	
	
	
	
}
