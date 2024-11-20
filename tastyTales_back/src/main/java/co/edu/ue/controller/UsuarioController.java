package co.edu.ue.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.Usuario;
import co.edu.ue.repository.dto.UsuarioDto;
import co.edu.ue.service.IUsuarioService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin("*")
@RequestMapping(value="api")
public class UsuarioController {

	@Autowired
	IUsuarioService service;
	
	@Autowired
	ModelMapper modelMapper;
	
	@GetMapping(value = "usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> getUsuarios() {
		return new ResponseEntity<List<Usuario>>(service.listAllUsuarios(), HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value = "registro-usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuario postUsuarios(@RequestBody UsuarioDto usuarioDto) {
	    Usuario usuario = modelMapper.map(usuarioDto, Usuario.class);
	    System.out.println("No quiere imprimir el cuerpo ----- " + usuarioDto.getUserDoc() + " " + usuarioDto.getUserNombre() + usuarioDto.getUserPassword()); 
	    //   return service.addUsuario(usuario);
	    return usuario;
	}
	
//	@GetMapping(value = "usuarios-dto", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<UsuarioDto>> UsuarioDto() {
//		return new ResponseEntity<List<UsuarioDto>>(service.listUsuariosDto(), HttpStatus.ACCEPTED);
//	}
}
