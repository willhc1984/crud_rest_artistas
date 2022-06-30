package com.example.artistas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.artistas.model.Musica;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Integer>{

}
