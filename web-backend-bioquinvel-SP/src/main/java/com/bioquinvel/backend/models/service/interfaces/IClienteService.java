package com.bioquinvel.backend.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.bioquinvel.backend.models.entities.Cliente;

public interface IClienteService {
	public void save(Cliente cliente);
	public Optional<Cliente> findById(Integer id);
	public void delete(Integer id);
	public List<Cliente> findAll();
}
