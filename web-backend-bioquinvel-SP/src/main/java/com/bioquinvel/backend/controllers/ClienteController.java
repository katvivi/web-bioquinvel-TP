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

import com.bioquinvel.backend.models.entities.Cliente;
import com.bioquinvel.backend.models.service.interfaces.IClienteService;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	IClienteService service;
	
	@PostMapping("/create")
	
	public ResponseEntity<?> create(@RequestBody Cliente c) {
		try {
			service.save(c);
			return ResponseEntity.status(HttpStatus.CREATED).body(c);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	//Retrieve
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<?> retrieve(@PathVariable Integer id) {
		try {
			Optional<Cliente> c = service.findById(id);
			if(c.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR --CLIENTE-- NO ENCONTRADO");
			}
			return ResponseEntity.ok(c);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Cliente c) {
		try {
			c.setIdcliente(id);
			service.save(c);
			return ResponseEntity.ok(c);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id) {
		try {
			Optional<Cliente> c = service.findById(id);
			if(c.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR --CLIENTE-- NO ENCONTRADO");
			}
			service.delete(id);
			return ResponseEntity.ok(c);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//List
		@GetMapping("/list")
		public ResponseEntity<?> list() {
			try {
				List<Cliente> c = service.findAll();
				if(c.isEmpty()) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR --CLIENTE-- NO ENCONTRADO");
				}
				return ResponseEntity.ok(c);
			}
			catch(Exception ex) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
			}
		}

}
