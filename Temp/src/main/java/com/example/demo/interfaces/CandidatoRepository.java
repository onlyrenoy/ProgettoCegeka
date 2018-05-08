package com.example.demo.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Long>
{
	
}
