package com.example.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Competenze {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_competenze")
	private int idCompetenze;
	
	private String categoria;
	private String nome;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "competenze")
	private List<CandidatoCompetenze> competenzeCandidato;
	
	@ManyToMany
	@JoinTable(
	name="competenza_offerta" , 
	    joinColumns=
		@JoinColumn(name="competenza_Id", nullable=false), 
		inverseJoinColumns=
		@JoinColumn(name="offerta_Id", nullable=false)
	)
	private List<Offerta> offerte;
	
	
	public Competenze() {
	
	}
	
	
	

	public int getIdCompetenze() {
		return idCompetenze;
	}



	public void setIdCompetenze(int idCompetenze) {
		this.idCompetenze = idCompetenze;
	}



	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
