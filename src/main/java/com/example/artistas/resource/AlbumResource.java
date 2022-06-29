package com.example.artistas.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.artistas.model.Album;
import com.example.artistas.services.AlbumService;

@RestController
@RequestMapping(value = "/album")
public class AlbumResource {
	
	@Autowired
	private AlbumService service;
	
	@GetMapping
	public List<Album> listar(){
		List<Album> albuns = service.buscarTodos();
		return albuns;
	}
	
	@GetMapping(value = "{id}")
	public Album buscarPorId(@PathVariable Integer id) {
		Album album = service.buscar(id);
		return album;
	}

}
