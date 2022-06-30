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
import javax.persistence.Transient;

@Entity
public class Album implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer ano;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "ALBUM_PARTICIPANTE",
			joinColumns = @JoinColumn(name = "album_id"),
			inverseJoinColumns = @JoinColumn(name = "artista_id"))	
	private List<Artista> participantes = new ArrayList<>();
	
	@Transient
	private List<Musica> musicas = new ArrayList<>();
	
	public Album(){
	}

	public Album(Integer id, String nome, Integer ano) {
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
	
	public List<Artista> getParticipantes() {
		return participantes;
	}

	public List<Musica> getMusicas() {
		return musicas;
	}
	
	public void addMusica(Musica musica) {
		musicas.add(musica);
	}
	
	public void addParticipantes(Artista artista) {
		participantes.add(artista);
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
		Album other = (Album) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", nome=" + nome + ", ano=" + ano + ", participantes=" + participantes + ", musicas="
				+ musicas + "]";
	}
	
	
	
}
