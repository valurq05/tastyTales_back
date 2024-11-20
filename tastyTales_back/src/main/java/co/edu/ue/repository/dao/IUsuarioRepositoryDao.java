package co.edu.ue.repository.dao;

import java.util.List;

import co.edu.ue.entity.Usuario;

public interface IUsuarioRepositoryDao {
	
	List<Usuario> createUsuario(Usuario usuario);
	Usuario updateUsuario(Usuario usuario);
	Usuario findByIdUsuario(int id);
	List<Usuario> listAllUsuarios();
	
}
