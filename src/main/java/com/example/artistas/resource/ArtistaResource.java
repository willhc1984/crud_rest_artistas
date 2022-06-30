package com.example.artistas.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.artistas.model.Artista;
import com.example.artistas.services.ArtistaService;

@RestController
@RequestMapping(value = "/artista")
public class ArtistaResource {
	
	@Autowired
	private ArtistaService service;
	
	@GetMapping
	public List<Artista> buscar(){
		List<Artista> artistas = service.buscarTodos();
		return artistas;
	}
	
	@GetMapping(value = "/{id}")
	public Artista buscarPorId(@PathVariable Integer id) {
		Artista artista = service.buscarPorId(id);
		return artista;		
	}

}
