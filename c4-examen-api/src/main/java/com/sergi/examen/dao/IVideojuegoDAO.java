package com.sergi.examen.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sergi.examen.dto.Videojuego;

public interface IVideojuegoDAO extends JpaRepository<Videojuego, Integer>{
}
