package com.example.demo.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Candidato;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Integer>
{
	public List<Candidato> findByNome(String nome);
	
	public List<Candidato> findByCognome(String cognome);
	
	@Query("select c" + 
			" from Candidato c, CanditatoCompetenze cc, Competenze co" + 
			" where co.nome =:competenze and c.idCandidato = cc.candidati.idCandidato")
	public List<Candidato> findBySkill(@Param("competenze") String competenze);
}
