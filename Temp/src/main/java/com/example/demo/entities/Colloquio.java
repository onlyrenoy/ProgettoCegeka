package com.example.demo.entities;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Colloquio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_colloquio")
	private int idColloquio;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataOra;
	
	private String feedback;
	
	private String dipartimento;
	
	private String statoColloquio;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Intervistatore intervistatore;
	@ManyToOne(cascade = CascadeType.ALL)
	private Candidato candidato;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Offerta offerta;
	
	public Colloquio() {
		
	}
	
	public int getIdColloquio() {
		return idColloquio;
	}

	public void setIdColloquio(int idColloquio) {
		this.idColloquio = idColloquio;
	}

	public Date getDataOra() {
		return dataOra;
	}

	public void setDataOra(Date dataOra) {
		this.dataOra = dataOra;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getDipartimento() {
		return dipartimento;
	}

	public void setDipartimento(String dipartimento) {
		this.dipartimento = dipartimento;
	}

	public String getStatoColloquio() {
		return statoColloquio;
	}

	public void setStatoColloquio(String stato) {
		this.statoColloquio = stato;
	}

	public Intervistatore getIntervistatore() {
		return intervistatore;
	}

	public void setIntervistatore(Intervistatore intervistatore) {
		this.intervistatore = intervistatore;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Offerta getOfferta() {
		return offerta;
	}

	public void setOfferta(Offerta offerta) {
		this.offerta = offerta;
	}

	@Override
	public String toString() {
		return "Colloquio [idColloquio=" + idColloquio + ", dataOra=" + dataOra + ", feedback=" + feedback
				+ ", dipartimento=" + dipartimento + ", statoColloquio=" + statoColloquio + ", intervistatore="
				+ intervistatore + ", candidato=" + candidato + ", offerta=" + offerta + "]";
	}
	

}
