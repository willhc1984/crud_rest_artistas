package com.example.artistas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Artista implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String nacionalidade;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "participantes", cascade = CascadeType.REMOVE)
	private List<Album> albuns = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.REMOVE)
	@JoinTable(name = "artista_musicanterpretada", 
		joinColumns = @JoinColumn(name = "artista_id"),
		inverseJoinColumns = @JoinColumn(name = "musica_id"))
	private List<Musica> musicasInterpretadas = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.REMOVE)
	@JoinTable(name = "artista_musicacomoAutor",
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
