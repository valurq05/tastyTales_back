package co.edu.ue.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Dato;
import co.edu.ue.repository.jpa.IDatoJPA;

@Repository
public class DatoRepositoryDao implements IDatoRepositoryDao {

	@Autowired
	IDatoJPA jpa;
	
	@Override
	public List<Dato> insertDato(Dato dato) {
		jpa.save(dato);
		return listDatos();
	}

	@Override
	public Dato updateDato(Dato dato) {
		return jpa.save(dato);
	}

	@Override
	public Dato findIdDato(int id) {
		return jpa.findById(id).orElse(null);
	}

	@Override
	public List<Dato> listDatos() {
		return jpa.findAll();
	}

	@Override
	public Dato findEmailDato(String mail) {
		return jpa.findByDatEmail(mail);
	}
	
	
}
