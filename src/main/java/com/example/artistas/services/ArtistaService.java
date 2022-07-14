package com.example.artistas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.artistas.model.Artista;
import com.example.artistas.repositories.ArtistaRepository;

@Service
public class ArtistaService {
	
	@Autowired
	private ArtistaRepository repository;
	
	public List<Artista> buscarTodos() {
		return repository.findAll();
	}
	
	public Artista buscarPorId(Integer id) {
		Optional<Artista> artista = repository.findById(id);
		return artista.get();
	}
	
	public Artista salvar(Artista artista) {
		return repository.save(artista);
	}
	
	public Artista atualizar(Artista artista) {
		return repository.save(artista);
	}
	
	public void apagar(Integer id) {
		repository.deleteById(id);
	}

}
