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
import com.sergi.examen.dto.Party;
import com.sergi.examen.service.PartyServiceImpl;

@RestController
@RequestMapping("/api")
public class PartyController {
	
	@Autowired
	PartyServiceImpl partyServiceImpl;
	
	@GetMapping("/party")
	public List<Party> listarParty(){
		return partyServiceImpl.listarParty();
	}
	
	@PostMapping("/party")
	public Party salvarParty(@RequestBody Party party) {
		return partyServiceImpl.guardarParty(party);
	}
	
	
	@GetMapping("/party/{id}")
	public Party PartyXID(@PathVariable(name="id") int id) {
		Party Party_x_id = new Party();
		Party_x_id = partyServiceImpl.partyXID(id);
		
		System.out.println("Party X id: " + Party_x_id);
		return Party_x_id;
	}
	
	@PutMapping("/party/{id}")
	public Party actualizarParty(@PathVariable(name="id")int id,@RequestBody Party Party) {
		Party Party_seleccionado = new Party();
		Party Party_actualizado = new Party();
		
		Party_seleccionado = partyServiceImpl.partyXID(id);
		
		Party_seleccionado.setNombre(Party.getNombre());
		Party_seleccionado.setVideojuego(Party.getVideojuego());
		Party_seleccionado.setUsuario(Party.getUsuario());
		
		Party_actualizado = partyServiceImpl.actualizarParty(Party_seleccionado);
		
		System.out.println("El Suministro actualizado es: " + Party_actualizado);
		return Party_actualizado;
	}
	
	@DeleteMapping("/party/{id}")
	public void eleiminarParty(@PathVariable(name="id")int id) {
		partyServiceImpl.eliminarParty(id);
	}
	
}
