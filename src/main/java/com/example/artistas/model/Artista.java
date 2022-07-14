package com.example.artistas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Artista implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String nacionalidade;

	@JsonManagedReference
	@ManyToMany(mappedBy = "participantes")
	private List<Album> albuns = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "artista_musica", 
		joinColumns = @JoinColumn(name = "artista_id"),
		inverseJoinColumns = @JoinColumn(name = "musica_id"))
	private List<Musica> musicasInterpretadas = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "artista_musica",
				joinColumns = @JoinColumn(name = "artista_id"),
				inverseJoinColumns = @JoinColumn(name = "musica_id"))
	private List<Musica> musicasComoAutor = new ArrayList<>();
	
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
		Artista other = (Artista) obj;
		return Objects.equals(id, other.id);
	}

}
