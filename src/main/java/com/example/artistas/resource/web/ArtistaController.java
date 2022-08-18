package com.example.artistas.resource.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.artistas.model.dto.ArtistaDTO;
import com.example.artistas.services.ArtistaService;


@Controller
@RequestMapping(value = "/web/artistas")
public class ArtistaController {
	
	@Autowired
	private ArtistaService service;
	
	@GetMapping("/cadastro")
	public String cadastro(ArtistaDTO artistaDTO) {
		return "cad-artista";
	}
	
	
}
