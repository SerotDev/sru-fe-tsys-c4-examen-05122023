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
import com.sergi.examen.dto.Videojuego;
import com.sergi.examen.service.VideojuegoServiceImpl;

@RestController
@RequestMapping("/api")
public class VideojuegoController {
	
	@Autowired
	VideojuegoServiceImpl videojuegoServiceImpl;
	
	@GetMapping("/videojuegos")
	public List<Videojuego> listarCusuarios(){
		return videojuegoServiceImpl.listarVideojuegos();
	}
	
	@PostMapping("/videojuegos")
	public Videojuego salvarVideojuego(@RequestBody Videojuego usuario) {
		return videojuegoServiceImpl.guardarVideojuego(usuario);
	}
	
	@GetMapping("/videojuegos/{id}")
	public Videojuego VideojuegoXID(@PathVariable(name="id") int id) {
		Videojuego Videojuego_x_id = new Videojuego();
		Videojuego_x_id = videojuegoServiceImpl.videojuegoXID(id);
		
		System.out.println("Videojuego X id: " + Videojuego_x_id);
		return Videojuego_x_id;
	}
	
	@PutMapping("/videojuegos/{id}")
	public Videojuego actualizarVideojuego(@PathVariable(name="id")int id,@RequestBody Videojuego Videojuego) {
		Videojuego Videojuego_seleccionado = new Videojuego();
		Videojuego Videojuego_actualizado = new Videojuego();
		
		Videojuego_seleccionado = videojuegoServiceImpl.videojuegoXID(id);
		
		Videojuego_seleccionado.setNombre(Videojuego.getNombre());
		
		Videojuego_actualizado = videojuegoServiceImpl.actualizarVideojuego(Videojuego_seleccionado);
		
		System.out.println("El Videojuego actualizada es: " + Videojuego_actualizado);
		return Videojuego_actualizado;
	}
	
	@DeleteMapping("/videojuegos/{id}")
	public void eleiminarVideojuego(@PathVariable(name="id")int id) {
		videojuegoServiceImpl.eliminarVideojuego(id);
	}
	
}
