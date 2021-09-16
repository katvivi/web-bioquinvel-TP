package com.bioquinvel.backend.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bioquinvel.backend.models.entities.Adicional;
import com.bioquinvel.backend.models.entities.Detalle;
import com.bioquinvel.backend.models.repositories.IAdicional;
import com.bioquinvel.backend.models.repositories.IDetalle;
import com.bioquinvel.backend.models.service.interfaces.IAdicionalService;

@Service
public class AdicionalService implements IAdicionalService{
	@Autowired
	IAdicional dao;
	
	@Autowired
	IDetalle daoDetalle;
	
	@Override
	@Transactional
	public void save(Adicional v) {
		dao.save(v);
		for(Detalle b : v.getFormulas()) {
			b.setAdicional(v);
			daoDetalle.save(b);
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Adicional> findById(Integer id) {		
		return dao.findById(id);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Optional<Adicional> findByCodigo(String codigo) {		
		return dao.findByCodigo(codigo);
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		Optional<Adicional> inv = dao.findById(id);
		if(inv == null) return;
		for(Detalle b : inv.get().getFormulas()) {
			daoDetalle.deleteById(b.getIdDetalle());
		}
		dao.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Adicional> findAll() {		
		return (List<Adicional>) dao.findAll();
	}
	
}
