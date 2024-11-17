package co.edu.ue.repository.dao;

import java.util.List;

import co.edu.ue.entity.Categoria;

public interface ICategoriaRepositoryDao {

	List<Categoria> insertCategoria(Categoria categoria);
	Categoria updateCategoria(Categoria categoria);
	Categoria findIdCategoria(int id);
	
	List<Categoria> listAllCategorias();

}
