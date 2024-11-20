package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Usuario;

public interface IUsuarioService {
	
	List<Usuario> addUsuario(Usuario usuario);
	Usuario upUsuario(Usuario usuario);
	Usuario findUsuario(int id);
	List<Usuario> listAllUsuarios();
	
}
