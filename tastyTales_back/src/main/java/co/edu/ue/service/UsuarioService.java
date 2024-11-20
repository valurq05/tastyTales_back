package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.entity.Usuario;
import co.edu.ue.repository.dao.IUsuarioRepositoryDao;

@Service
public class UsuarioService implements IUsuarioService{

	@Autowired
	IUsuarioRepositoryDao dao;
	
	@Override
	public List<Usuario> addUsuario(Usuario usuario) {
		dao.createUsuario(usuario);
		return listAllUsuarios();
	}

	@Override
	public Usuario upUsuario(Usuario usuario) {
		return dao.updateUsuario(usuario);
	}

	@Override
	public Usuario findUsuario(int id) {
		return dao.findByIdUsuario(id);
	}

	@Override
	public List<Usuario> listAllUsuarios() {
		return dao.listAllUsuarios();
	}

}
