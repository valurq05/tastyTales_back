package co.edu.ue.repository.dao;

import java.util.List;

import co.edu.ue.entity.Adicionale;


public interface IAdicionalRepositoryDao {

	List<Adicionale> insertDato(Adicionale adicional);
	Adicionale updateDato(Adicionale adicional);
	Adicionale findIdDato(int id);
	
	List<Adicionale> listDatos();
	
}
