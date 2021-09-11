package com.bioquinvel.backend.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bioquinvel.backend.models.entities.Producto;
import com.bioquinvel.backend.models.repositories.IProducto;
import com.bioquinvel.backend.models.service.interfaces.IProductoService;

@Service
public class ProductoService implements IProductoService {

	@Autowired
	IProducto repository;

	@Override
	@Transactional
	public void save(Producto producto) {
		repository.save(producto);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Producto> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Producto> findByNombre(String nombre) {
		return repository.findByNombre(nombre);

	}

	@Override
	@Transactional
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) repository.findAll();
	}
}
