package co.edu.ue.repository.dao;

import java.util.List;

import co.edu.ue.entity.CalificacionReceta;

public interface ICalificacionRecetaRepositoryDao {

	List<CalificacionReceta> insertCalifReceta(CalificacionReceta CalificacionReceta);
	CalificacionReceta updateCalifReceta(CalificacionReceta CalificacionReceta);
	CalificacionReceta findIdCalifReceta(int id);
	
	List<CalificacionReceta> listAllCalifRecetas();
}
