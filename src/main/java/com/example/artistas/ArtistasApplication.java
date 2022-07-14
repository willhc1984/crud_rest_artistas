package com.example.artistas;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.artistas.model.Album;
import com.example.artistas.model.Artista;
import com.example.artistas.model.Musica;
import com.example.artistas.repositories.AlbumRepository;
import com.example.artistas.repositories.ArtistaRepository;
import com.example.artistas.repositories.MusicaRepository;

@SpringBootApplication
public class ArtistasApplication implements CommandLineRunner{
	
	@Autowired
	private AlbumRepository albumRepository;
	@Autowired
	private ArtistaRepository artistaRepository;
	@Autowired
	private MusicaRepository musicaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ArtistasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Album alb1 = new Album(null, "Led Zepellin IV", 520);
		Album alb2 = new Album(null, "Led Zeppelin V", 474);
		Album alb3 = new Album(null, "Master of Puppets", 145);
		Album alb4 = new Album(null, "Acoustica", 874);
		Album alb5 = new Album(null, "Vertigo", 637);
		Album alb6 = new Album(null, "One", 745);
		
		Artista art1 = new Artista(null, "Led Zeppelin", "Inglaterra");
		Artista art2 = new Artista(null, "Metallica", "USA");
		Artista art3 = new Artista(null, "U2", "Irlanda");
		Artista art4 = new Artista(null, "Scorpions", "Alemanha");
		
		Musica m1 = new Musica(null, "Stairway to Heaven", 587);
		Musica m2 = new Musica(null, "Still loving you", 354);
		Musica m3 = new Musica(null, "Beautiful Day", 365);
		Musica m4 = new Musica(null, "One", 45);
		Musica m5 = new Musica(null, "Kashimir", 254);
		
		alb1.getParticipantes().addAll(Arrays.asList(art1));
		alb1.getMusicas().addAll(Arrays.asList(m1, m5));
		alb2.getParticipantes().addAll(Arrays.asList(art1));
		alb2.getMusicas().addAll(Arrays.asList(m1, m5));
		alb3.getParticipantes().addAll(Arrays.asList(art2));
		alb3.getMusicas().addAll(Arrays.asList(m4));
		alb4.getParticipantes().addAll(Arrays.asList(art4));
		alb4.getMusicas().addAll(Arrays.asList(m2));
		alb5.getParticipantes().addAll(Arrays.asList(art3));
		alb5.getMusicas().addAll(Arrays.asList(m3));
		alb6.getParticipantes().addAll(Arrays.asList(art2));
		
		art1.getAlbuns().addAll(Arrays.asList(alb1, alb2));
		art2.getAlbuns().addAll(Arrays.asList(alb3, alb6));
		art3.getAlbuns().addAll(Arrays.asList(alb5));
		art4.getAlbuns().addAll(Arrays.asList(alb4));
		
		m1.getAlbuns().addAll(Arrays.asList(alb1, alb2));
		m2.getAlbuns().addAll(Arrays.asList(alb4));
		m3.getAlbuns().addAll(Arrays.asList(alb5));
		m4.getAlbuns().addAll(Arrays.asList(alb4));
		m5.getAlbuns().addAll(Arrays.asList(alb1, alb2));
		
		albumRepository.saveAll(Arrays.asList(alb1, alb2, alb3, alb4, alb5, alb6));
		artistaRepository.saveAll(Arrays.asList(art1, art2, art3, art4));
		musicaRepository.saveAll(Arrays.asList(m1, m2, m3, m4, m5));
		
		

			
		/*
		 * art2.getAlbuns().addAll(Arrays.asList(alb3));
		 * art3.getAlbuns().addAll(Arrays.asList(alb5));
		 * art4.getAlbuns().addAll(Arrays.asList(alb4));
		 */
		
		
		
		
		
		
		
		
	}

}
