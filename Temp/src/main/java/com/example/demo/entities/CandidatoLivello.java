package com.example.demo.entities;

public class CandidatoLivello {
	
	private Candidato candidato;
	
	private int contatore = 0;

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public int getContatore() {
		return contatore;
	}

	public void setContatore(int contatore) {
		this.contatore = contatore;
	}

}
