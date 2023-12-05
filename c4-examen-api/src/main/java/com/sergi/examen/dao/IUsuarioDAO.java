package com.sergi.examen.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sergi.examen.dto.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Integer>{
	
}
