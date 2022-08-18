package com.example.artistas.resource.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.artistas.model.dto.ArtistaDTO;
import com.example.artistas.services.ArtistaService;


@Controller
@RequestMapping(value = "/web/artistas")
public class ArtistaController {
	
	@Autowired
	private ArtistaService service;
	
	@GetMapping("/lista")
	public String getAll(ModelMap model) {
		model.addAttribute("artistas", service.buscarTodos());
		return "lista-artista";
	}
	
	@GetMapping("/cadastro")
	public String save(ArtistaDTO artistaDTO) {
		return "cad-artista";
	}
	
	@PostMapping("/cadastro")
	public String create(@Valid ArtistaDTO artistaDTO, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "cad-artista";
		}
		try {
			service.salvar(artistaDTO);
			attr.addFlashAttribute("success", "Artista cadastrado!");
			return "redirect:/web/artistas/cadastro";
		} catch (Exception e) {
			attr.addFlashAttribute("fail", "Erro: Violação de chave.");
			return "redirect:/web/artistas/cadastro";
		}		
	}
	
	
}
