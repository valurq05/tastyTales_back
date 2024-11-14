package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.Dato;
import co.edu.ue.service.IDatoService;

@RestController
@CrossOrigin("*")
@RequestMapping(value="dato")
public class AdicionalController {
	
	@Autowired
	IDatoService service;
	
	//EndPoint
	
	@GetMapping(value="datos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Dato>> getAllDatos() {
		// 1. Agregar en la cabecera la cantidad de registros
		List<Dato> datos = service.listAllDatos();
		int cantDatos = datos.size();
		// 2. cantDatos agregarlo a la cabecera del servicio
		
		HttpHeaders headers = new HttpHeaders(); // Se instancio un objeto de tipo HttpHeaders
		headers.add("cant_datos", String.valueOf(cantDatos));
		headers.add("test", "es el endPoint datos");
		
		// 3. Cambiar la respuesta del método a response entity
		// 4. Cambiar el return con ResponseEntity
		
		return new ResponseEntity<List<Dato>>(datos, headers, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="dato-mail", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Dato> getDatoByEmail(@RequestParam("email") String email) {
		return new ResponseEntity<Dato>(service.findEmailDato(email), HttpStatus.ACCEPTED);
	}
	
	//Respuesta de tipo Void
	@PostMapping(value="postDatos", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Void> postDatos(@RequestBody Dato dato) {
		int sizeListBefore = service.listAllDatos().size();
		int sizeListAfter = service.listAllDatos().size();
		if(sizeListAfter>sizeListBefore) {
			return new ResponseEntity<Void> (HttpStatus.OK);			
		}		
		return new ResponseEntity<Void>(HttpStatus.CONFLICT);			
	}
}
