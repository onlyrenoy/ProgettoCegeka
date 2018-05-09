package com.example.demo.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Colloquio;

public interface ColloquioRepository extends JpaRepository<Colloquio,Integer> {

	public List<Colloquio> findByCandidatoNome(String nome);
	public List<Colloquio> findByIntervistatoreNome(String nome);
	public List<Colloquio> findByOffertaRuolo(String ruolo);
	
}
