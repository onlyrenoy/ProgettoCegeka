package com.azienda.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Candidato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_candidato")
	private int idCandidato;
	
	@ManyToOne (cascade = CascadeType.ALL)
	private CanditatoCompetenze candidatoCompetenze;

	private String nome;
	
	private String cognome;
	
	private int eta;
		
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "candidato")
	List<Colloquio> colloqui;
	
	public Candidato() {
		
	}
	
	public int getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(int idCandidato) {
		this.idCandidato = idCandidato;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public List<Colloquio> getColloqui() {
		return colloqui;
	}

	public void setColloqui(List<Colloquio> colloqui) {
		this.colloqui = colloqui;
	}

}
