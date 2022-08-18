package com.example.artistas.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.example.artistas.model.Album;
import com.example.artistas.model.Artista;
import com.example.artistas.model.Musica;

public class MusicaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotBlank(message = "Nome não pode ser nulo")
	private String nome;
	@Min(value = 1, message = "Duração minima deve ser 1 minuto")
	private Integer duracao;
	
	private List<Artista> interpretes = new ArrayList<>();

	private List<Artista> autores = new ArrayList<>();
	
	private List<Album> albuns = new ArrayList<>();
	
	public MusicaDTO() {
	}
	
	public MusicaDTO(Musica musica) {
		this.id = musica.getId();
		this.nome = musica.getNome();
		this.duracao = musica.getDuracao();
		this.interpretes = musica.getInterpretes();
		this.autores = musica.getAutores();
		this.albuns = musica.getAlbuns();
	}

	public MusicaDTO(Integer id, String nome, Integer duracao) {
		super();
		this.id = id;
		this.nome = nome;
		this.duracao = duracao;
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

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public List<Artista> getInterpretes() {
		return interpretes;
	}

	public void setInterpretes(List<Artista> interpretes) {
		this.interpretes = interpretes;
	}

	public List<Artista> getAutores() {
		return autores;
	}

	public void setAutores(List<Artista> autores) {
		this.autores = autores;
	}

	public List<Album> getAlbuns() {
		return albuns;
	}

	public void setAlbuns(List<Album> albuns) {
		this.albuns = albuns;
	}

}
