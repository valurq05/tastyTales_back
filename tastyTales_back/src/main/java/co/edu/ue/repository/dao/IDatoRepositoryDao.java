package co.edu.ue.repository.dao;

import java.util.List;

import co.edu.ue.entity.Dato;

public interface IDatoRepositoryDao {

	List<Dato> insertDato(Dato dato);
	Dato updateDato(Dato dato);
	Dato findIdDato(int id);
	
	List<Dato> listDatos();
	Dato findEmailDato(String mail);
	
}
