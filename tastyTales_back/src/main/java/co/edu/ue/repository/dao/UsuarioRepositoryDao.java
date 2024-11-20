package co.edu.ue.repository.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Usuario;
import co.edu.ue.repository.jpa.IUsuarioJpa;

@Repository
public class UsuarioRepositoryDao implements IUsuarioRepositoryDao{

	@Autowired
	IUsuarioJpa jpa;

	@Override
	public List<Usuario> createUsuario(Usuario usuario) {
		jpa.save(usuario);
		return listAllUsuarios();
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		int id = usuario.getUserID();
		Usuario toUpdateUsuario = jpa.findById(id).orElse(null);
		toUpdateUsuario = usuario;
		return toUpdateUsuario;
	}

	@Override
	public Usuario findByIdUsuario(int id) {
		return jpa.findById(id).orElse(null);
	}

	@Override
	public List<Usuario> listAllUsuarios() {
		return jpa.findAll();
	}
}
