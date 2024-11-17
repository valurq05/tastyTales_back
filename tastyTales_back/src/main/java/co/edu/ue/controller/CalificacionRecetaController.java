package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.CalificacionReceta;
import co.edu.ue.service.ICalificacionRecetaService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@CrossOrigin("*")
@RequestMapping(value="api")
public class CalificacionRecetaController {

	@Autowired
	ICalificacionRecetaService service;
	
	@GetMapping("calif-receta")
	public ResponseEntity<List<CalificacionReceta>> getCalificacionReceta() {
		return new ResponseEntity<>(service.listAllCalifRecetas(), HttpStatus.ACCEPTED);
	}
	
}
