package com.bioquinvel.backend.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.bioquinvel.backend.models.entities.Direccion;

public interface IDireccionService {
	public void save(Direccion direccion);
	public Optional<Direccion> findById(Integer id);
	public void delete(Integer id);
	public List<Direccion> findAll();
}
