package com.example.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Intervistatore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_intervistatore")
	private int idIntervistatore;
	
	private String nome;
	
	private String cognome;
	
	private String dipartimento;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="intervistatore")
	private List<Colloquio> colloqui;
	
	private String posizioneNelDipartimento;
	
	public Intervistatore() {
		
	}

	public int getIdIntervistatore() {
		return idIntervistatore;
	}

	public void setIdIntervistatore(int idIntervistatore) {
		this.idIntervistatore = idIntervistatore;
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

	public String getPosizioneNelDipartimento() {
		return posizioneNelDipartimento;
	}

	public void setPosizioneNelDipartimento(String posizioneNelDipartimento) {
		this.posizioneNelDipartimento = posizioneNelDipartimento;
	}
	
	

}
