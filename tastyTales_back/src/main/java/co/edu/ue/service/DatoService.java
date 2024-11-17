package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.entity.Dato;
import co.edu.ue.repository.dao.IDatoRepositoryDao;

@Service
public class DatoService implements IDatoService {
	
	@Autowired
	IDatoRepositoryDao dao;
	
	@Override
	public List<Dato> addDato(Dato dato) {
		return dao.insertDato(dato);
	}

	@Override
	public Dato upDato(Dato dato) {
		return dao.updateDato(dato);
	}

	@Override
	public Dato findIdDato(int id) {
		return dao.findIdDato(id);
	}

	@Override
	public List<Dato> listAllDatos() {
		return dao.listDatos();
	}

	@Override
	public Dato findEmailDato(String mail) {
		return dao.findEmailDato(mail);
	}
	
}
