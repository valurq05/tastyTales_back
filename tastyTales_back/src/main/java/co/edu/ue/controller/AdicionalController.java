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

import co.edu.ue.entity.Adicional;
import co.edu.ue.service.IAdicionalService;

@RestController
@CrossOrigin("*")
@RequestMapping(value="api")
public class AdicionalController {
	
	@Autowired
	IAdicionalService service;
	
	//EndPoint
	
	@GetMapping(value="adicional", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Adicional>> getAllAdicional() {
		// 1. Agregar en la cabecera la cantidad de registros
		List<Adicional> adicional = service.listAllAdicionales();
		int cantAdicional = adicional.size();
		// 2. cantAdicional agregarlo a la cabecera del servicio
		
		HttpHeaders headers = new HttpHeaders(); // Se instancio un objeto de tipo HttpHeaders
		headers.add("cant_Adicional", String.valueOf(cantAdicional));
		headers.add("test", "es el endPoint Adicional");
		
		// 3. Cambiar la respuesta del método a response entity
		// 4. Cambiar el return con ResponseEntity
		
		return new ResponseEntity<List<Adicional>>(adicional, headers, HttpStatus.ACCEPTED);
	}
	
//	@GetMapping(value="adicional-mail", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Adicional> getadicionalByEmail(@RequestParam("email") String email) {
//		return new ResponseEntity<Adicional>(service.findEmailadicional(email), HttpStatus.ACCEPTED);
//	}
	
	//Respuesta de tipo Void
	@PostMapping(value="postAdicional", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Void> postAdicional(@RequestBody Adicional adicional) {
		int sizeListBefore = service.listAllAdicionales().size();
		service.addAdicionales(adicional);
		int sizeListAfter = service.listAllAdicionales().size();
		if(sizeListAfter>sizeListBefore) {
			return new ResponseEntity<Void> (HttpStatus.OK);			
		}		
		return new ResponseEntity<Void>(HttpStatus.CONFLICT);			
	}
}
