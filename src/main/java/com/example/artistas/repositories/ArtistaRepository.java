package com.example.artistas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.artistas.model.Artista;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Integer>{

}
