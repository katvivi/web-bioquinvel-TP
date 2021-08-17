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

import com.bioquinvel.backend.models.entities.LineaPedido;
import com.bioquinvel.backend.models.service.interfaces.ILineaPedidoService;

@RestController
@RequestMapping("/lineaPedido")
public class LineaPedidoController {
	@Autowired
	ILineaPedidoService service;
	
	//CRUC - L 
	
	//Create
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody LineaPedido l) {
		try {
			service.save(l);
			return ResponseEntity.status(HttpStatus.CREATED).body(l);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	//Retrieve
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<?> retrieve(@PathVariable Integer id) {
		try {
			Optional<LineaPedido> l = service.findById(id);
			if(l.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR NO ENCONTRADO");
			}
			return ResponseEntity.ok(l);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody LineaPedido l) {
		try {
			l.setIdLineaPedido(id);
			service.save(l);
			return ResponseEntity.ok(l);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id) {
		try {
			Optional<LineaPedido> l = service.findById(id);
			if(l.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR NO ENCONTRADO");
			}
			service.delete(id);
			return ResponseEntity.ok(l);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//List
	@GetMapping("/list")
	public ResponseEntity<?> list() {
		try {
			List<LineaPedido> l = service.findAll();
			if(l.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR NO ENCONTRADO");
			}
			return ResponseEntity.ok(l);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}

}
