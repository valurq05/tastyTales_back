package co.edu.ue.repository.dao;

import java.util.List;

import co.edu.ue.entity.Calificacionreceta;

public interface ICalificacionRecetaRepositoryDao {

	List<Calificacionreceta> insertDato(Calificacionreceta calificacionReceta);
	Calificacionreceta updateDato(Calificacionreceta calificacionReceta);
	Calificacionreceta findIdDato(int id);
	
	List<Calificacionreceta> listDatos();
}
