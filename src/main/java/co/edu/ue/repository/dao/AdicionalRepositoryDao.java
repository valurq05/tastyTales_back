package co.edu.ue.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.ue.entity.Adicionale;
import co.edu.ue.repository.jpa.IAdicionalJpa;

public class AdicionalRepositoryDao implements IAdicionalRepositoryDao {

	@Autowired
	IAdicionalJpa jpa;
	
	@Override
	public List<Adicionale> insertDato(Adicionale adicional) {
		jpa.save(adicional);
		return listDatos();
	}

	@Override
	public Adicionale updateDato(Adicionale adicional) {
		return jpa.save(adicional);
	}

	@Override
	public Adicionale findIdDato(int id) {
		return jpa.findById(id).orElse(null);
	}

	@Override
	public List<Adicionale> listDatos() {
		
		return jpa.findAll();
	}

}
