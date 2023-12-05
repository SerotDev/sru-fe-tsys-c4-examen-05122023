package com.sergi.examen.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sergi.examen.dto.Usuario;
import com.sergi.examen.service.UsuarioServiceImpl;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;

	@GetMapping("/usuario/login")
	public Usuario login() {
		return null;
	}

	@PostMapping("/usuario/registrar")
	public Usuario registrarUsuario(@RequestBody Usuario usuario) {
		return usuarioServiceImpl.registrarUsuario(usuario);
	}

	@GetMapping("/usuario/{id}")
	public Usuario usuarioXid(@PathVariable(name = "id") int id) {
		Usuario Usuario_x_id = new Usuario();
		Usuario_x_id = usuarioServiceImpl.logout(id);

		System.out.println("Usuario X id: " + Usuario_x_id);
		return Usuario_x_id;
	}

	@PutMapping("/usuario/{id}")
	public Usuario modificarPerfil(@PathVariable(name = "id") int id, @RequestBody Usuario usuario) {
		Usuario Usuario_seleccionado = new Usuario();
		Usuario Usuario_actualizado = new Usuario();

		Usuario_seleccionado = usuarioServiceImpl.logout(id);
		Usuario_seleccionado.setId(usuario.getId());

		Usuario_actualizado = usuarioServiceImpl.modificarPerfil(Usuario_seleccionado);

		return Usuario_actualizado;
	}

}
