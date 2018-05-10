package com.example.demo.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Offerta;

public interface OffertaRepository extends JpaRepository<Offerta,Integer>{
	
	public List<Offerta> findByStatoOfferta(String stato);

}
