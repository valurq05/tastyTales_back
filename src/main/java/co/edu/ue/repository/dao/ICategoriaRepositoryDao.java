package co.edu.ue.repository.dao;

import java.util.List;

import co.edu.ue.entity.Categoria;

public interface ICategoriaRepositoryDao {

	List<Categoria> insertDato(Categoria categoria);
	Categoria updateDato(Categoria categoria);
	Categoria findIdDato(int id);
	
	List<Categoria> listDatos();

}
