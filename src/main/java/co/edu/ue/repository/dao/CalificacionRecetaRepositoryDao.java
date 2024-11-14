package co.edu.ue.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.ue.entity.Calificacionreceta;
import co.edu.ue.repository.jpa.ICalificacionRecetaJpa;

public class CalificacionRecetaRepositoryDao implements ICalificacionRecetaRepositoryDao{

	@Autowired
	ICalificacionRecetaJpa jpa;
	
	@Override
	public List<Calificacionreceta> insertDato(Calificacionreceta calificacionReceta) {
		jpa.save(calificacionReceta);
		return null;
	}

	@Override
	public Calificacionreceta updateDato(Calificacionreceta calificacionReceta) {
		return jpa.save(calificacionReceta);
	}

	@Override
	public Calificacionreceta findIdDato(int id) {
		return jpa.findById(id).orElse(null);
	}

	@Override
	public List<Calificacionreceta> listDatos() {
		return jpa.findAll();
	}

}
