package com.bioquinvel.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bioquinvel.backend.models.entities.Adicional;
import com.bioquinvel.backend.models.service.interfaces.IAdicionalService;



@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/adicional")
public class AdicionalController {
	@Autowired
	IAdicionalService service;
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Adicional v) {
		try {
			service.save(v);
			return ResponseEntity.status(HttpStatus.CREATED).body(v);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	//Retrieve
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<?> retrieve(@PathVariable Integer id) {
		try {
			Optional<Adicional> v = service.findById(id);
			if(v.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Adicional no encontrada");
			}
			return ResponseEntity.ok(v);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
	
	@GetMapping("/retrieve")
	public ResponseEntity<?> retrieveByName(@RequestParam String codigo) {
		try {
			Optional<Adicional> v = service.findByCodigo(codigo);
			if(v.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Adicional no encontrado");
			}
			return ResponseEntity.ok(v);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Adicional v) {
		try {
			v.setIdAdicional(id);
			service.save(v);
			return ResponseEntity.ok(v);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id) {
		try {
			Optional<Adicional> v = service.findById(id);
			if(v.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Adicional no encontrada");
			}
			service.delete(id);
			return ResponseEntity.ok(v);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	//List
	@GetMapping("/list")
	public ResponseEntity<?> list() {
		try {
			List<Adicional> vars = service.findAll();
			if(vars.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay variadades registradas");
			}
			return ResponseEntity.ok(vars);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
	

}
