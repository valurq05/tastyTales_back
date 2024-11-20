package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Usuario;
import co.edu.ue.repository.dto.UsuarioDto;

public interface IUsuarioService {
	
	Usuario addUsuario(Usuario usuario);
	Usuario upUsuario(Usuario usuario);
	Usuario findUsuario(int id);
	List<Usuario> listAllUsuarios();
	
}
