package co.edu.ue.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Paso;
import co.edu.ue.repository.jpa.IPasoJpa;

@Repository
public class PasoRepositoryDao implements IPasoRepositoryDao{
	
	@Autowired
	IPasoJpa jpa;

	@Override
	public List<Paso> createPaso(Paso paso) {
		jpa.save(paso);
		return listAllPasos();
	}

	@Override
	public Paso updatePaso(Paso paso) {
		return jpa.save(paso);
	}

	@Override
	public Paso findIdPaso(int id) {
		return jpa.findById(id).orElse(null);
	}

	@Override
	public List<Paso> listAllPasos() {
		return jpa.findAll();
	}
}
