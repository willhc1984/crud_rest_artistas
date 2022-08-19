package com.example.artistas.resource.web;

import java.util.List;

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
import com.example.artistas.model.dto.MusicaDTO;
import com.example.artistas.services.ArtistaService;
import com.example.artistas.services.MusicaService;
import com.example.artistas.services.exceptions.IntegrityViolationException;

@Controller
@RequestMapping(value = "/web/musicas")
public class MusicaController {

	@Autowired
	private MusicaService service;
	
	@Autowired
	private ArtistaService artistaService;

	@GetMapping("/lista")
	public String getAll(ModelMap model) {
		model.addAttribute("musicas", service.buscarTodos());
		return "lista-musica";
	}

	@GetMapping("/cadastro")
	public String save(MusicaDTO musicaDTO, ModelMap model) {
		List<ArtistaDTO> dto = artistaService.buscarTodos();
		model.addAttribute("artistas", dto);
		return "cad-musica";
	}

	@PostMapping("/cadastro")
	public String create(@Valid MusicaDTO musicaDTO, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "cad-musica";
		}
		try {
			service.salvar(musicaDTO);
			attr.addFlashAttribute("success", "Musica cadastrada!");
			return "redirect:/web/musicas/cadastro";
		} catch (Exception e) {
			attr.addFlashAttribute("fail", "Erro: Violação de chave.");
			return "redirect:/web/musicas/cadastro";
		}
	}

	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes attr) {
		try {
			service.apagar(id);
			attr.addFlashAttribute("success", "Musica excluida!");
			return "redirect:/web/musicas/lista";
		} catch (IntegrityViolationException e) {
			e.printStackTrace();
			attr.addFlashAttribute("fail", "Erro: " + e.getMessage());
			return "redirect:/web/musicas/lista";
		}
	}

	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable Integer id, ModelMap model) {
		model.addAttribute("musicaDTO", service.buscarPorId(id));
		return "atualizar-musica";
	}

	@PostMapping(value = "/update/{id}")
	public String update(@Valid MusicaDTO dto, BindingResult result, @PathVariable Integer id, RedirectAttributes attr,
			ModelMap model) {
		if (result.hasErrors()) {
			return "atualizar-musica";
		}

		try {
			service.atualizar(dto, id);
			attr.addFlashAttribute("success", "Musica atualizada!");
			return "redirect:/web/musicas/lista";
		} catch (IntegrityViolationException e) {
			attr.addFlashAttribute("fail", "Erro: " + e.getMessage());
			return "redirect:/web/musicas/lista";
		}
	}
}
