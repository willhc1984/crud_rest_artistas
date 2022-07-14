package com.example.artistas.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.artistas.model.Artista;
import com.example.artistas.services.ArtistaService;

@RestController
@RequestMapping(value = "/artistas")
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
	
	@PostMapping
	public void salvar(@RequestBody Artista artista) {
		service.salvar(artista);
	}
	
	@PutMapping(value = "/{id}")
	public void  atualizar(@RequestBody Artista artista) {
		service.atualizar(artista);
	}
	
	@DeleteMapping(value = "/{id}")
	public void apagar(@PathVariable Integer id) {
		service.apagar(id);
	}

}
