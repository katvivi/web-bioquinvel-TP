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

import com.bioquinvel.backend.models.entities.Producto;
import com.bioquinvel.backend.models.service.interfaces.IProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	IProductoService service;
	
	@PostMapping("/create")
	
	public ResponseEntity<?> create(@RequestBody Producto pro) {
		try {
			service.save(pro);
			return ResponseEntity.status(HttpStatus.CREATED).body(pro);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	//Retrieve
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<?> retrieve(@PathVariable Integer id) {
		try {
			Optional<Producto> pro = service.findById(id);
			if(pro.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR --PRODUCTO-- NO ENCONTRADO");
			}
			return ResponseEntity.ok(pro);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}		
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Producto pro) {
		try {
			pro.setIdProducto(id);
			service.save(pro);
			return ResponseEntity.ok(pro);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id) {
		try {
			Optional<Producto> pro = service.findById(id);
			if(pro.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR --PRODUCTO-- NO ENCONTRADO");
			}
			service.delete(id);
			return ResponseEntity.ok(pro);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	//List
	@GetMapping("/list")
	public ResponseEntity<?> list() {
		try {
			List<Producto> pro = service.findAll();
			if(pro.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR --PRODUCTO-- NO ENCONTRADO");
			}
			return ResponseEntity.ok(pro);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
}
