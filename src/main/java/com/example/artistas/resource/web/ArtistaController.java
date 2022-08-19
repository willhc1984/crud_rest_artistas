package com.example.artistas.resource.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.artistas.model.dto.ArtistaDTO;
import com.example.artistas.services.ArtistaService;
import com.example.artistas.services.exceptions.IntegrityViolationException;


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
	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes attr){
		try {
			service.apagar(id);
			attr.addFlashAttribute("success", "Artista excluido!");
			return "redirect:/web/artistas/lista";
		} catch (IntegrityViolationException e) {
			e.printStackTrace();
			attr.addFlashAttribute("fail", "Erro: " + e.getMessage());
			return "redirect:/web/artistas/lista";
		}
	}
	
	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable Integer id, ModelMap model) {
		model.addAttribute("artistaDTO", service.buscarPorId(id));
		return "atualizar-artista";
	}
	
	@PostMapping(value = "/update/{id}")
	public String update(@Valid ArtistaDTO dto, BindingResult result, @PathVariable Integer id, RedirectAttributes attr, ModelMap model) {
		if(result.hasErrors()) {
			return "atualizar-artista";
		}
		
		try {
			service.atualizar(id, dto);
			attr.addFlashAttribute("success", "Artista atualizado!");
			return "redirect:/web/artistas/lista";
		} catch (IntegrityViolationException e) {
			attr.addFlashAttribute("fail", "Erro: " + e.getMessage());
			return "redirect:/web/artistas/lista";
		}
	}
	
	
	
}
