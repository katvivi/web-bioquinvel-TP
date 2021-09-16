package com.bioquinvel.backend.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.bioquinvel.backend.models.entities.Adicional;

public interface IAdicionalService {
	void save(Adicional v);
	Optional<Adicional> findById(Integer id);
	void delete(Integer id);
	List<Adicional> findAll();
	Optional<Adicional> findByCodigo(String codigo);
}
