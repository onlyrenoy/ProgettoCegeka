package com.example.demo.entities;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




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
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "candidato_id")
	private Candidato candidati;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "competenze_id")
	private Competenze competenze;

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

	public Candidato getCandidati() {
		return candidati;
	}

	public void setCandidati(Candidato candidati) {
		this.candidati = candidati;
	}

	public Competenze getCompetenze() {
		return competenze;
	}

	public void setCompetenze(Competenze competenze) {
		this.competenze = competenze;
	}

	
	
	
	
	
	
}
