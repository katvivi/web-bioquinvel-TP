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
import org.springframework.web.bind.annotation.RestController;

import com.bioquinvel.backend.models.entities.Administrativo;
import com.bioquinvel.backend.models.service.interfaces.IAdministrativoService;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/administrador")
public class AdministrativoController {
	@Autowired
	IAdministrativoService service;
	
	@PostMapping("/create")
	
	public ResponseEntity<?> create(@RequestBody Administrativo a) {
		try {
			service.save(a);
			return ResponseEntity.status(HttpStatus.CREATED).body(a);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	//Retrieve
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<?> retrieve(@PathVariable Integer id) {
		try {
			Optional<Administrativo> a = service.findById(id);
			if(a.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR --ADMINISTRADOR-- NO ENCONTRADO");
			}
			return ResponseEntity.ok(a);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
	
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Administrativo a) {
		try {
			a.setIdAdministrativo(id);
			service.save(a);
			return ResponseEntity.ok(a);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id) {
		try {
			Optional<Administrativo> a = service.findById(id);
			if(a.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR --ADMINISTRADOR-- NO ENCONTRADO");
			}
			service.delete(id);
			return ResponseEntity.ok(a);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//List
	@GetMapping("/list")
	public ResponseEntity<?> list() {
		try {
			List<Administrativo> a = service.findAll();
			if(a.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR --ADMINISTRADOR-- NO ENCONTRADO");
			}
			return ResponseEntity.ok(a);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

}
