package com.bioquinvel.backend.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bioquinvel.backend.models.entities.Cliente;
import com.bioquinvel.backend.models.repositories.ICliente;
import com.bioquinvel.backend.models.service.interfaces.IClienteService;

@Service
public class ClienteService implements IClienteService{
	@Autowired	
	ICliente repository; 
	
	@Override
	@Transactional
	public void save(Cliente cliente) {
		repository.save(cliente);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Cliente> findById(Integer id) {		
		return repository.findById(id);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		repository.deleteById(id);				
	}

	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {		
		return repository.findAll();
	}
}
