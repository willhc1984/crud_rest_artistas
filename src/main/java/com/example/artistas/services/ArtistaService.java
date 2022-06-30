package com.example.artistas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.artistas.model.Artista;
import com.example.artistas.repositories.ArtistaRepository;

@Service
public class ArtistaService {
	
	@Autowired
	private ArtistaRepository repository;
	
	public List<Artista> buscarTodos(){
		return repository.findAll();
	}
	
	public Artista buscarPorId(@PathVariable Integer id) {
		Optional<Artista> artista = repository.findById(id);
		return artista.get();
	}

}