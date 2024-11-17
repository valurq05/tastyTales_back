package co.edu.ue.repository.dao;

import java.util.List;

import co.edu.ue.entity.Paso;

public interface IPasoRepositoryDao {

	List<Paso> createPaso(Paso paso);
	Paso updatePaso(Paso paso);
	Paso findIdPaso(int id);
	List<Paso> listAllPasos();
	
}
