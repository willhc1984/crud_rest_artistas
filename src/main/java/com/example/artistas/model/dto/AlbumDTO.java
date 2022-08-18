package com.example.artistas.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.artistas.model.Album;
import com.example.artistas.model.Artista;
import com.example.artistas.model.Musica;

public class AlbumDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotBlank(message = "Nome não deve ser nulo")
	private String nome;
	@Min(value = 1950, message = "O ano deve ser de 1950 em diante")
	private Integer ano;
	
	private List<Musica> musicas = new ArrayList<>();
	private List<Artista> participantes = new ArrayList<>();
	
	public AlbumDTO() {
	}
	
	public AlbumDTO(Album album) {
		this.id = album.getId();
		this.nome = album.getNome();
		this.ano = album.getAno();
		this.musicas = album.getMusicas();
		this.participantes = album.getParticipantes();
	}

	public AlbumDTO(Integer id, @NotBlank(message = "Nome não deve ser nulo") String nome, Integer ano) {
		super();
		this.id = id;
		this.nome = nome;
		this.ano = ano;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public List<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}

	public List<Artista> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Artista> participantes) {
		this.participantes = participantes;
	}

}
