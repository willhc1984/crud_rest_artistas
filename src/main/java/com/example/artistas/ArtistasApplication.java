package com.example.artistas;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.artistas.model.Album;
import com.example.artistas.model.Artista;
import com.example.artistas.repositories.AlbumRepository;
import com.example.artistas.repositories.ArtistaRepository;

@SpringBootApplication
public class ArtistasApplication implements CommandLineRunner{
	
	@Autowired
	private AlbumRepository albumRepository;
	@Autowired
	private ArtistaRepository artistaRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(ArtistasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Album alb1 = new Album(null, "Led Zepellin IV", 520);
		Album alb2 = new Album(null, "Led Zeppelin V", 474);
		Album alb3 = new Album(null, "Master of Puppets", 145);
		Album alb4 = new Album(null, "Acoustica", 874);
		
		
		Artista art1 = new Artista(null, "Led Zeppelin", "Inglaterra");
		Artista art2 = new Artista(null, "Metallica", "USA");
		Artista art3 = new Artista(null, "U2", "Irlanda");
		Artista art4 = new Artista(null, "Scorpions", "Alemanha");
		
		albumRepository.saveAll(Arrays.asList(alb1, alb2, alb3, alb4));
		artistaRepository.saveAll(Arrays.asList(art1, art2, art3, art4));
		
		alb1.getParticipantes().addAll(Arrays.asList(art1));
		alb3.getParticipantes().addAll(Arrays.asList(art2));
		alb4.getParticipantes().addAll(Arrays.asList(art4));
	}

}
