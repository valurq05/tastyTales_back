package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.Categoria;
import co.edu.ue.service.ICategoriaService;

@RestController
@CrossOrigin("*")
@RequestMapping(value="api")
public class CategoriaController {

	@Autowired
	ICategoriaService service;
	
	@GetMapping("categorias")
	public ResponseEntity<List<Categoria>> getCategorias(){
		return new ResponseEntity<List<Categoria>>(service.listAllCategoria(), HttpStatus.ACCEPTED);
	}
}
