package com.example.artistas.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.artistas.model.Musica;
import com.example.artistas.model.dto.MusicaDTO;
import com.example.artistas.repositories.MusicaRepository;
import com.example.artistas.services.exceptions.DeleteException;
import com.example.artistas.services.exceptions.IntegrityViolationException;
import com.example.artistas.services.exceptions.NotFoundException;

@Service
public class MusicaService {
	
	@Autowired
	private MusicaRepository repository;
	
	public List<MusicaDTO> buscarTodos() {
		List<Musica> musicas = repository.findAll();
		List<MusicaDTO> musicasDto = new ArrayList<>();
		for(Musica m : musicas) {
			MusicaDTO dto = new MusicaDTO(m);
			musicasDto.add(dto);
		}
		return musicasDto;
	}
	
	public MusicaDTO buscarPorId(Integer id) {
		Musica musica = repository.findById(id)
				.orElseThrow(() -> new NotFoundException("Id não encontrado - " + id));
		MusicaDTO dto = new MusicaDTO(musica);
		return dto;
	}
	
	public MusicaDTO salvar(MusicaDTO dto) {
		Musica entity = new Musica();
		copyToEntity(dto, entity);
		repository.save(entity);
		return new MusicaDTO(entity);
	}
	
	private void copyToEntity(MusicaDTO dto, Musica entity) {
		entity.setNome(dto.getNome());
		entity.setDuracao(dto.getDuracao());
		
	}

	public MusicaDTO atualizar(MusicaDTO dto, Integer id) {
		Musica entity = repository.getReferenceById(id);
		updateData(entity, dto);
		entity = repository.save(entity);
		return new MusicaDTO(entity);
	}
	
	private void updateData(Musica entity, MusicaDTO dto) {
		entity.setNome(dto.getNome());
		entity.setDuracao(dto.getDuracao());
		
	}

	public void apagar(Integer id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException  e) {
			throw new IntegrityViolationException("Violação de integridade de dados");
		}catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			throw new DeleteException("Id não existe - " + id);
		}
		
	}

}
