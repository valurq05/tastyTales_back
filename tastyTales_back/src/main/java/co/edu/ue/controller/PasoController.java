package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.Paso;
import co.edu.ue.service.IPasoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value="api")
public class PasoController {

	@Autowired
	IPasoService service;
	
	@GetMapping(value="pasos")
	public ResponseEntity<List<Paso>> getPasos(){
		return new ResponseEntity<List<Paso>>(service.listAllPasos(), HttpStatus.ACCEPTED);
	}
}
