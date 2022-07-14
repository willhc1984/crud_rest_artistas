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
	
	@PostMapping
	public void salvar(@RequestBody Musica musica) {
		service.salvar(musica);
	}
	
	@PutMapping(value = "/{id}")
	public void  atualizar(@RequestBody Musica musica) {
		service.atualizar(musica);
	}
	
	@DeleteMapping(value = "/{id}")
	public void apagar(@PathVariable Integer id) {
		service.apagar(id);
	}
	
}
