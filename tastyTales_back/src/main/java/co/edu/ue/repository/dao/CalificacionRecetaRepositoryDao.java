package co.edu.ue.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.CalificacionReceta;
import co.edu.ue.repository.jpa.ICalificacionRecetaJpa;

@Repository
public class CalificacionRecetaRepositoryDao implements ICalificacionRecetaRepositoryDao{
	
	@Autowired
	ICalificacionRecetaJpa jpa;	
	
	@Override
	public List<CalificacionReceta> insertCalifReceta(CalificacionReceta calificacionReceta) {
		jpa.save(calificacionReceta);
		return listAllCalifRecetas();
	}

	@Override
	public CalificacionReceta updateCalifReceta(CalificacionReceta calificacionReceta) {
		return jpa.save(calificacionReceta);
	}

	@Override
	public CalificacionReceta findIdCalifReceta(int id) {
		return jpa.findById(id).orElse(null);
	}

	@Override
	public List<CalificacionReceta> listAllCalifRecetas() {
		return jpa.findAll();
	}

}
