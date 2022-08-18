package com.example.artistas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.artistas.model.Artista;
import com.example.artistas.model.Musica;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Integer>{
	
	public List<Musica> findAllByOrderByNome();
	
}
