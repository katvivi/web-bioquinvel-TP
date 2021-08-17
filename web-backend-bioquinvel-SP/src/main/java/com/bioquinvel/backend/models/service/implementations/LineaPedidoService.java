package com.bioquinvel.backend.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bioquinvel.backend.models.entities.LineaPedido;
import com.bioquinvel.backend.models.repositories.ILineaPedido;
import com.bioquinvel.backend.models.service.interfaces.ILineaPedidoService;

@Service
public class LineaPedidoService implements ILineaPedidoService{
	
	@Autowired	
	ILineaPedido repository; 
		
	@Override
	@Transactional
	public void save(LineaPedido lineaPedido) {
		repository.save(lineaPedido);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<LineaPedido> findById(Integer id) {		
		return repository.findById(id);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		repository.deleteById(id);				
	}

	@Override
	@Transactional(readOnly=true)
	public List<LineaPedido> findAll() {		
		return (List<LineaPedido>) repository.findAll();
	}
}
