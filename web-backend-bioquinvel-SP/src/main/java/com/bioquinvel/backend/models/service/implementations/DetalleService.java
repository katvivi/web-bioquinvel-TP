package com.bioquinvel.backend.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bioquinvel.backend.models.entities.Detalle;
import com.bioquinvel.backend.models.repositories.IDetalle;
import com.bioquinvel.backend.models.service.interfaces.IDetalleService;

@Service
public class DetalleService implements IDetalleService{
	@Autowired
	IDetalle dao;
	
	@Override
	public void save(Detalle v) {
		dao.save(v);
	}

	@Override
	public Optional<Detalle> findById(Integer id) {		
		return dao.findById(id);
	}

	@Override
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	public List<Detalle> findAll() {		
		return (List<Detalle>) dao.findAll();
	}
}
