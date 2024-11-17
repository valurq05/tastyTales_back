package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.entity.CalificacionReceta;
import co.edu.ue.repository.dao.ICalificacionRecetaRepositoryDao;

@Service
public class CalificacionRecetaService implements ICalificacionRecetaService{

	@Autowired
	ICalificacionRecetaRepositoryDao dao;
	
	@Override
	public List<CalificacionReceta> createCalifReceta(CalificacionReceta calificacionReceta) {
		dao.insertCalifReceta(calificacionReceta);
		return listAllCalifRecetas();
	}

	@Override
	public CalificacionReceta updateCalifReceta(CalificacionReceta calificacionReceta) {
		dao.updateCalifReceta(calificacionReceta);
		return calificacionReceta;
	}

	@Override
	public CalificacionReceta findIdCalifReceta(int id) {
		return dao.findIdCalifReceta(id);
	}

	@Override
	public List<CalificacionReceta> listAllCalifRecetas() {
		return dao.listAllCalifRecetas();
	}

}
