package com.example.artistas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.artistas.model.Album;
import com.example.artistas.repositories.AlbumRepository;

@Service
public class AlbumService {
	
	@Autowired
	private AlbumRepository repository;
	
	public List<Album> buscarTodos() {
		return repository.findAll();
	}
	
	public Album buscarPorId(Integer id) {
		Optional<Album> album = repository.findById(id);
		return album.get();
	}

}
