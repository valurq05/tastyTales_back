package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Dato;

public interface IDatoService {
	
	List<Dato> addDato(Dato dato);
	Dato upDato(Dato dato);
	Dato findIdDato(int id);
	
	List<Dato> listAllDatos();
	Dato findEmailDato(String datEmail);
}
