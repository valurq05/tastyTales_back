package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.entity.Categoria;
import co.edu.ue.repository.dao.ICategoriaRepositoryDao;

@Service
public class CategoriaService implements ICategoriaService{

	@Autowired
	ICategoriaRepositoryDao dao;
	
	@Override
	public List<Categoria> addCategoria(Categoria categoria) {
		dao.insertCategoria(categoria);
		return listAllCategoria();
	}

	@Override
	public Categoria upCategoria(Categoria categoria) {
		dao.updateCategoria(categoria);
		return categoria;
	}

	@Override
	public Categoria findIdCategoria(int id) {
		return dao.findIdCategoria(id);
	}

	@Override
	public List<Categoria> listAllCategoria() {
		return dao.listAllCategorias();
	}

}
