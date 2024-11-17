package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.entity.Paso;
import co.edu.ue.repository.dao.IPasoRepositoryDao;

@Service
public class PasoService implements IPasoService{

	@Autowired
	IPasoRepositoryDao dao;
	
	@Override
	public List<Paso> addPaso(Paso paso) {
		dao.createPaso(paso);
		return listAllPasos();
	}

	@Override
	public Paso upDato(Paso paso) {
		dao.updatePaso(paso);
		return paso;
	}

	@Override
	public Paso findIdPaso(int id) {
		return dao.findIdPaso(id);
	}

	@Override
	public List<Paso> listAllPasos() {
		return dao.listAllPasos();
	}

}
