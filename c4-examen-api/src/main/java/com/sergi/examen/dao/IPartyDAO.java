package com.sergi.examen.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sergi.examen.dto.Party;

public interface IPartyDAO extends JpaRepository<Party, Integer>{
}
