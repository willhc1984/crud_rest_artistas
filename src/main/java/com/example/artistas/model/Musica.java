package com.example.artistas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Musica implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer duracao;
	
	@ManyToMany(mappedBy = "musicasInterpretadas")
	private List<Artista> interpretes = new ArrayList<>();
	@ManyToMany(mappedBy = "musicasComoAutor")
	private List<Artista> autores = new ArrayList<>();
	@JsonBackReference
	@ManyToMany(mappedBy = "musicas")
	private List<Album> albuns = new ArrayList<>();
	
	public Musica() {
	}

	public Musica(Integer id, String nome, Integer duracao) {
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

	public List<Artista> getAutores() {
		return autores;
	}

	public List<Album> getAlbuns() {
		return albuns;
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
		Musica other = (Musica) obj;
		return Objects.equals(id, other.id);
	}

	/*
	 * @Override public String toString() { return "Musica [id=" + id + ", nome=" +
	 * nome + ", duracao=" + duracao + ", interpretes=" + interpretes + ", autores="
	 * + autores + ", albuns=" + albuns + "]"; }
	 */
	
	

}
