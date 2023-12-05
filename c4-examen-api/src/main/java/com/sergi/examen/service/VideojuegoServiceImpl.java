package com.sergi.examen.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sergi.examen.dao.IVideojuegoDAO;
import com.sergi.examen.dto.Videojuego;

@Service
public class VideojuegoServiceImpl implements IVideojuegoService {
	
	@Autowired
	IVideojuegoDAO iVideojuegoDAO;

	@Override
	public List<Videojuego> listarVideojuegos() {
		return iVideojuegoDAO.findAll();
	}

	@Override
	public Videojuego guardarVideojuego(Videojuego usuario) {
		return iVideojuegoDAO.save(usuario);
	}

	@Override
	public Videojuego videojuegoXID(int id) {
		return iVideojuegoDAO.findById(id).get();
	}

	@Override
	public Videojuego actualizarVideojuego(Videojuego usuario) {
		return iVideojuegoDAO.save(usuario);
	}

	@Override
	public void eliminarVideojuego(int id) {
		iVideojuegoDAO.deleteById(id);
	}

}
