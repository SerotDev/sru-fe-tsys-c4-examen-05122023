package com.sergi.examen.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sergi.examen.dao.IUsuarioDAO;
import com.sergi.examen.dto.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	IUsuarioDAO iUsuarioDAO;

	@Override
	public Usuario registrarUsuario(Usuario usuario) {
		return iUsuarioDAO.save(usuario);
	}

	@Override
	public Usuario login(String username, String contrasena) {
		return iUsuarioDAO.findBy(null, null);
	}

	@Override
	public Usuario modificarPerfil(Usuario usuario) {
		return iUsuarioDAO.save(usuario);
	}

	@Override
	public Usuario logout(int id) {
		return iUsuarioDAO.findById(id).get();
	}

}
