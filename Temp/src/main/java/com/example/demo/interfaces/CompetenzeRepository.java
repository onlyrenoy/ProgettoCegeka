package com.example.demo.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Competenze;

public interface CompetenzeRepository extends JpaRepository<Competenze, Integer>
{
	public List<Competenze> findByNome(String nome);
	
	public List<Competenze> findByCategoria(String categoria);
	
}
