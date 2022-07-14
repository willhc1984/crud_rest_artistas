package com.example.artistas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.artistas.model.Musica;
import com.example.artistas.repositories.MusicaRepository;

@Service
public class MusicaService {
	
	@Autowired
	private MusicaRepository repository;
	
	public List<Musica> buscarTodos() {
		return repository.findAll();
	}
	
	public Musica buscarPorId(Integer id) {
		Optional<Musica> musica = repository.findById(id);
		return musica.get();
	}
	
	public Musica salvar(Musica musica) {
		return repository.save(musica);
	}
	
	public Musica atualizar(Musica musica) {
		return repository.save(musica);
	}
	
	public void apagar(Integer id) {
		repository.deleteById(id);
	}

}
