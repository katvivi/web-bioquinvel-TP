package com.bioquinvel.backend.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.bioquinvel.backend.models.entities.Producto;


public interface IProductoService {
	public void save(Producto p);
	public Optional<Producto> findById(Integer id);
	public Optional<Producto> findByNombre(String nombre);
	public void delete(Integer id);
	public List<Producto> findAll();
}
