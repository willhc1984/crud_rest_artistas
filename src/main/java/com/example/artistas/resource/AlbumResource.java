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

import com.example.artistas.model.Album;
import com.example.artistas.services.AlbumService;

@RestController
@RequestMapping(value = "/albuns")
public class AlbumResource {
	
	@Autowired
	private AlbumService service;
	
	@GetMapping
	public List<Album> buscar(){
		List<Album> albuns = service.buscarTodos();
		return albuns;
	}
	
	@GetMapping(value = "/{id}")
	public Album buscarPorId(@PathVariable Integer id) {
		Album album = service.buscarPorId(id);
		return album;
	}
	
	@PostMapping
	public void salvar(@RequestBody Album album) {
		service.salvar(album);
	}
	
	@PutMapping(value = "/{id}")
	public void  atualizar(@RequestBody Album album) {
		service.atualizar(album);
	}
	
	@DeleteMapping(value = "/{id}")
	public void apagar(@PathVariable Integer id) {
		service.apagar(id);
	}
	
	

}
