package com.example.artistas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Artista implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String nacionalidade;
	
	private List<Album> albuns = new ArrayList<>();
	private List<Musica> musicas = new ArrayList<>();
	
	public Artista() {
	}
	
	public Artista(Integer id, String nome, String nacionalidade) {
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
	

	public List<Musica> getMusicas() {
		return musicas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artista other = (Artista) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Artista [id=" + id + ", nome=" + nome + ", nacionalidade=" + nacionalidade + ", albuns=" + albuns
				+ ", musicas=" + musicas + "]";
	}	

}
