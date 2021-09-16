package com.bioquinvel.backend.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.bioquinvel.backend.models.entities.Detalle;

public interface IDetalleService {
	void save(Detalle v);
	Optional<Detalle> findById(Integer id);
	void delete(Integer id);
	List<Detalle> findAll();
}
