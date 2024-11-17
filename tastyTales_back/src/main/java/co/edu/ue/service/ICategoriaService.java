package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Categoria;

public interface ICategoriaService {
	List<Categoria> addCategoria(Categoria categoria);
	Categoria upCategoria(Categoria categoria);
	Categoria findIdCategoria(int id);
	List<Categoria> listAllCategoria();
	
}
