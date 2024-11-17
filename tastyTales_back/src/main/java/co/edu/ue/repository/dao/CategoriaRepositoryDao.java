package co.edu.ue.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Categoria;
import co.edu.ue.repository.jpa.ICategoriaJpa;

@Repository
public class CategoriaRepositoryDao implements ICategoriaRepositoryDao {
	
	@Autowired
	ICategoriaJpa jpa;
	
	@Override
	public List<Categoria> insertCategoria(Categoria categoria) {
		jpa.save(categoria);
		return listAllCategorias();
	}

	@Override
	public Categoria updateCategoria(Categoria categoria) {
		jpa.save(categoria);
		return categoria;
	}

	@Override
	public Categoria findIdCategoria(int id) {
		return jpa.findById(id).orElse(null);
	}

	@Override
	public List<Categoria> listAllCategorias() {
		return jpa.findAll();
	}

}
