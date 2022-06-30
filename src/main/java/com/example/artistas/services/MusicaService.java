package com.example.artistas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.artistas.model.Musica;
import com.example.artistas.repositories.MusicaRepository;

@Service
public class MusicaService {
	
	@Autowired
	private MusicaRepository repository;
	
	public List<Musica> buscarTodos(){
		return repository.findAll();
	}
	
	public Musica buscarPorId(@PathVariable Integer id){
		Optional<Musica> artista = repository.findById(id);
		return artista.get();
	}

}
