package co.edu.ue.controller;

import java.util.List;

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
import co.edu.ue.service.IUsuarioService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin("*")
@RequestMapping(value="api")
public class UsuarioController {

	@Autowired
	IUsuarioService service;

	@GetMapping(value = "usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> getUsuarios() {
		return new ResponseEntity<List<Usuario>>(service.listAllUsuarios(), HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value = "registro-usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuario postUsuarios(@RequestBody Usuario usuario){
		return usuario;
	}
}
