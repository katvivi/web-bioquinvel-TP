package com.bioquinvel.backend.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bioquinvel.backend.models.entities.Direccion;
import com.bioquinvel.backend.models.repositories.IDireccion;
import com.bioquinvel.backend.models.service.interfaces.IDireccionService;

@Service
public class DireccionService implements IDireccionService{
	
	@Autowired	
	IDireccion repository; 
		
	@Override
	@Transactional
	public void save(Direccion direccion) {
		repository.save(direccion);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Direccion> findById(Integer id) {		
		return repository.findById(id);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		repository.deleteById(id);				
	}

	@Override
	@Transactional(readOnly=true)
	public List<Direccion> findAll() {		
		return (List<Direccion>) repository.findAll();
	}
}
