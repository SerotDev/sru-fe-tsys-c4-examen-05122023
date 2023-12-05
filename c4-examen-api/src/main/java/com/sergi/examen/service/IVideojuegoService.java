package com.sergi.examen.service;

import java.util.List;

import com.sergi.examen.dto.Videojuego;

public interface IVideojuegoService {

	// Metodos del CRUD
	public List<Videojuego> listarVideojuegos(); // Listar All

	public Videojuego guardarVideojuego(Videojuego videojuego); // Guarda una Videojuego (CREATE)

	public Videojuego videojuegoXID(int id); // Lee datos de una Videojuego (READ)

	public Videojuego actualizarVideojuego(Videojuego videojuego); // Actualiza datos de la videojuego (UPDATE)

	public void eliminarVideojuego(int id);// Elimina la videojuego (DELETE)

}
