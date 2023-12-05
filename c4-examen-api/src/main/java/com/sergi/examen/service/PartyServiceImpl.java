package com.sergi.examen.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sergi.examen.dao.IPartyDAO;
import com.sergi.examen.dto.Party;

@Service
public class PartyServiceImpl implements IPartyService {
	
	@Autowired
	IPartyDAO iPartyDAO;

	@Override
	public List<Party> listarParty() {
		return iPartyDAO.findAll();
	}

	@Override
	public Party guardarParty(Party usuario) {
		return iPartyDAO.save(usuario);
	}

	@Override
	public Party partyXID(int id) {
		return iPartyDAO.findById(id).get();
	}

	@Override
	public Party actualizarParty(Party usuario) {
		return iPartyDAO.save(usuario);
	}

	@Override
	public void eliminarParty(int id) {
		iPartyDAO.deleteById(id);
	}

}
