package com.example.artistas.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.artistas.model.Artista;
import com.example.artistas.model.dto.ArtistaDTO;
import com.example.artistas.repositories.ArtistaRepository;
import com.example.artistas.services.exceptions.DeleteException;
import com.example.artistas.services.exceptions.EntityNotFoundException;
import com.example.artistas.services.exceptions.IntegrityViolationException;

@Service
public class ArtistaService {

	@Autowired
	private ArtistaRepository repository;

	public List<ArtistaDTO> buscarTodos() {
		List<Artista> artistas = repository.findAll();
		List<ArtistaDTO> artistasDto = new ArrayList<>();
		for (Artista a : artistas) {
			ArtistaDTO dto = new ArtistaDTO(a);
			artistasDto.add(dto);
		}
		return artistasDto;
	}

	public ArtistaDTO buscarPorId(Integer id) {
		Artista artista = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Id não encontrado - " + id));
		ArtistaDTO dto = new ArtistaDTO(artista);
		return dto;
	}

	public ArtistaDTO salvar(ArtistaDTO dto) {
		Artista entity = new Artista();
		copyToEntity(dto, entity);
		repository.save(entity);
		return new ArtistaDTO(entity);
	}

	private void copyToEntity(ArtistaDTO dto, Artista entity) {
		entity.setNome(dto.getNome());
		entity.setNacionalidade(dto.getNacionalidade());
	}

	public ArtistaDTO atualizar(Integer id, ArtistaDTO dto) {
		Artista obj = repository.getReferenceById(id);
		updateData(obj, dto);
		obj = repository.save(obj);
		return new ArtistaDTO(obj);

	}

	private void updateData(Artista obj, ArtistaDTO dto) {
		obj.setNome(dto.getNome());
		obj.setNacionalidade(dto.getNacionalidade());
	}

	public void apagar(Integer id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			throw new IntegrityViolationException("Violação de integridade de dados");
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			throw new DeleteException("Id não existe - " + id);
		}
	}

}
