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

import com.bioquinvel.backend.models.entities.Pedido;
import com.bioquinvel.backend.models.service.interfaces.IPedidoService;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/pedido")
public class PedidoController {
	@Autowired
	IPedidoService service;
	
	@PostMapping("/create")
	
	public ResponseEntity<?> create(@RequestBody Pedido p) {
		try {
			service.save(p);
			return ResponseEntity.status(HttpStatus.CREATED).body(p);
		}
		catch(Exception ex) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
			
		}
	}
	
	
	//Retrieve
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<?> retrieve(@PathVariable Integer id) {
		try {
			Optional<Pedido> p = service.findById(id);
			if(p.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR --PEDIDO-- NO ENCONTRADO");
			}
			return ResponseEntity.ok(p);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Pedido p) {
		try {
			p.setIdPedido(id);
			service.save(p);
			return ResponseEntity.ok(p);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id) {
		try {
			Optional<Pedido> p = service.findById(id);
			if(p.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR --PEDIDO-- NO ENCONTRADO");
			}
			service.delete(id);
			return ResponseEntity.ok(p);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//List
	@GetMapping("/list")
	public ResponseEntity<?> list() {
		try {
			List<Pedido> p = service.findAll();
			if(p.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR --PEDIDO-- NO ENCONTRADO");
			}
			return ResponseEntity.ok(p);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
}
