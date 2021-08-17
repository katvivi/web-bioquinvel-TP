package com.bioquinvel.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bioquinvel.backend.models.entities.Direccion;
import com.bioquinvel.backend.models.service.interfaces.IDireccionService;

@RestController
@RequestMapping("/direccion")
public class DireccionController {
	@Autowired
	IDireccionService service;
	
	@PostMapping("/create")
	
	public ResponseEntity<?> create(@RequestBody Direccion d) {
		try {
			service.save(d);
			return ResponseEntity.status(HttpStatus.CREATED).body(d);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	//Retrieve
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<?> retrieve(@PathVariable Integer id) {
		try {
			Optional<Direccion> d = service.findById(id);
			if(d.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR --DIRECCION-- NO ENCONTRADO");
			}
			return ResponseEntity.ok(d);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Direccion d) {
		try {
			d.setIdDireccion(id);
			service.save(d);
			return ResponseEntity.ok(d);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id) {
		try {
			Optional<Direccion> d = service.findById(id);
			if(d.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR --DIRECCION-- NO ENCONTRADO");
			}
			service.delete(id);
			return ResponseEntity.ok(d);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//List
		@GetMapping("/list")
		public ResponseEntity<?> list() {
			try {
				List<Direccion> d = service.findAll();
				if(d.isEmpty()) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR --DIRECCION-- NO ENCONTRADO");
				}
				return ResponseEntity.ok(d);
			}
			catch(Exception ex) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
			}
		}
}
