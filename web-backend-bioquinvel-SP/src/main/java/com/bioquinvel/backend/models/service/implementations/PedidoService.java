package com.bioquinvel.backend.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bioquinvel.backend.models.entities.Pedido;
import com.bioquinvel.backend.models.repositories.IPedido;
import com.bioquinvel.backend.models.service.interfaces.IPedidoService;

@Service
public class PedidoService implements IPedidoService{
	
	@Autowired	
	IPedido repository; 
	
	@Override
	@Transactional
	public void save(Pedido p) {
		repository.save(p);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Pedido> findById(Integer id) {		
		return repository.findById(id);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		repository.deleteById(id);				
	}

	@Override
	@Transactional(readOnly=true)
	public List<Pedido> findAll() {		
		return (List<Pedido>) repository.findAll();
	}
	
}
