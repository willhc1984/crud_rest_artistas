package com.example.artistas.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotBlank;

import com.example.artistas.model.Album;
import com.example.artistas.model.Artista;
import com.example.artistas.model.Musica;

public class ArtistaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotBlank(message = "Nome não pode ser nulo ou vazio.")
	private String nome;
	@NotBlank(message = "Nacionalidade não pode ser nula ou vazia.")
	
	private String nacionalidade;
	
	private List<Album> albuns = new ArrayList<>();
	
	private List<Musica> musicasInterpretadas = new ArrayList<>();
	
	private List<Musica> musicasComoAutor = new ArrayList<>();
	
	public ArtistaDTO() {
	}
	
	public ArtistaDTO(Artista artista) {
		this.id = artista.getId();
		this.nome = artista.getNome();
		this.nacionalidade = artista.getNacionalidade();
		this.albuns = artista.getAlbuns();
		this.musicasInterpretadas = artista.getMusicasInterpretadas();
		this.musicasComoAutor = artista.getMusicasComoAutor();
	}
	
	public ArtistaDTO(Integer id, String nome, String nacionalidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.nacionalidade = nacionalidade;
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

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	

	public List<Album> getAlbuns() {
		return albuns;
	}

	public List<Musica> getMusicasInterpretadas() {
		return musicasInterpretadas;
	}

	public List<Musica> getMusicasComoAutor() {
		return musicasComoAutor;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArtistaDTO other = (ArtistaDTO) obj;
		return Objects.equals(id, other.id);
	}

}
