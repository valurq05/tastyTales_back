package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Paso;

public interface IPasoService {
	List<Paso> addPaso(Paso paso);
	Paso upDato(Paso paso);
	Paso findIdPaso(int id);
	List<Paso> listAllPasos();
}