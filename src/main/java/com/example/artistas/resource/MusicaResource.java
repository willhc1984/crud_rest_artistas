package com.example.artistas.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.artistas.model.Musica;
import com.example.artistas.services.MusicaService;

@RestController
@RequestMapping(value = "/musicas")
public class MusicaResource {
	
	@Autowired
	private MusicaService service;
	
	@GetMapping
	public List<Musica> buscar(){
		List<Musica> musicas = service.buscarTodos();
		return musicas;
	}
	
	@GetMapping(value = "/{id}")
	public Musica buscarPorId(@PathVariable Integer id) {
		Musica musica = service.buscarPorId(id);
		return musica;		
	}
}
