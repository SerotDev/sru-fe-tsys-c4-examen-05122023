package com.sergi.examen.service;

import java.util.List;

import com.sergi.examen.dto.Usuario;

public interface IUsuarioService {

	// Metodos del CRUD
	public Usuario registrarUsuario(Usuario usuario); // Registra un nuevo Usuario (CREATE)

	public Usuario login(String username, String contrasena); // Usuario hace login (READ)

	public Usuario modificarPerfil(Usuario usuario); // Actualiza datos del perfil del Usuario (UPDATE)

	public Usuario logout(int id); // Usuario hace logout (READ)

}
