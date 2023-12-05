package com.sergi.examen.service;

import java.util.List;

import com.sergi.examen.dto.Party;

public interface IPartyService {

	//Metodos del CRUD
		public List<Party> listarParty(); //Listar All 
		
		public Party guardarParty(Party party);	//Guarda un Party CREATE
		
		public Party partyXID(int id); //Leer datos de un Party READ
		
		public Party actualizarParty(Party party); //Actualiza datos del Party UPDATE
		
		public void eliminarParty(int id);// Elimina el Party DELETE
	
}


