package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.CalificacionReceta;

public interface ICalificacionRecetaService {
	List<CalificacionReceta> createCalifReceta(CalificacionReceta calificacionReceta);
	CalificacionReceta updateCalifReceta(CalificacionReceta calificacionReceta);
	CalificacionReceta findIdCalifReceta(int id);
	List<CalificacionReceta> listAllCalifRecetas();
}
