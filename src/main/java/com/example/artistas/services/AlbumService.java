package com.example.artistas.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.artistas.model.Album;
import com.example.artistas.model.dto.AlbumDTO;
import com.example.artistas.repositories.AlbumRepository;
import com.example.artistas.services.exceptions.DeleteException;
import com.example.artistas.services.exceptions.IntegrityViolationException;
import com.example.artistas.services.exceptions.NotFoundException;

@Service
public class AlbumService {
	
	@Autowired
	private AlbumRepository repository;
	
	public List<AlbumDTO> buscarTodos() {
		List<Album> albuns = repository.findAll();
		List<AlbumDTO> albunsDto = new ArrayList<>();
		for(Album a : albuns) {
			AlbumDTO dto = new AlbumDTO(a);
			albunsDto.add(dto);
		}
		return albunsDto;
	}
	
	public AlbumDTO buscarPorId(Integer id) {
		Album album = repository.findById(id)
				.orElseThrow(() -> new NotFoundException("Id não encontrado - " + id));
		AlbumDTO albumDto = new AlbumDTO(album);
		return albumDto;
	}
	
	public AlbumDTO salvar(AlbumDTO dto) {
		Album entity = new Album();
		copyToEntity(dto, entity);
		repository.save(entity);
		return new AlbumDTO(entity);
	}
	
	private void copyToEntity(AlbumDTO dto, Album entity) {
		entity.setNome(dto.getNome());
		entity.setAno(dto.getAno());
		
	}

	public AlbumDTO atualizar(AlbumDTO dto, Integer id) {
		Album entity = repository.getReferenceById(id);
		updateData(entity, dto);
		try {
			entity = repository.save(entity);
		} catch (EntityNotFoundException  e) {
			throw new NotFoundException("Id não encontrado - " + id);
		}
		return new AlbumDTO(entity);
	}
	
	private void updateData(Album entity, AlbumDTO dto) {
		entity.setNome(dto.getNome());
		entity.setAno(dto.getAno());
	}

	public void apagar(Integer id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new IntegrityViolationException("Violação de integridade de dados");
		} catch (EmptyResultDataAccessException e) {
			throw new DeleteException("Id não existe - " + id);
		}
	}

}
