package com.example.artistas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.artistas.model.Artista;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Integer>, CrudRepository<Artista, Integer>{
	
	@Query("SELECT nome FROM Artista where nome like %:keyword% ")
	List<String> search(@Param("keyword") String keyword);
}
