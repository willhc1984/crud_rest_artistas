package com.example.artistas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.artistas.model.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer>{

}
