package co.edu.ue.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.ue.entity.Categoria;
import co.edu.ue.repository.jpa.ICategoriaJpa;

public class CategoriaRepositoryDao implements ICategoriaRepositoryDao{

	@Autowired
	ICategoriaJpa jpa;
	
	@Override
	public List<Categoria> insertDato(Categoria categoria) {
		jpa.save(categoria);
		return listDatos();
	}

	@Override
	public Categoria updateDato(Categoria categoria) {
		return jpa.save(categoria);
	}

	@Override
	public Categoria findIdDato(int id) {
		return jpa.findById(id).orElse(null);
	}

	@Override
	public List<Categoria> listDatos() {
		return jpa.findAll();
	}

}
