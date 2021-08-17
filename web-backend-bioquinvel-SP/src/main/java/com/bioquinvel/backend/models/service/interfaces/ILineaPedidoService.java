package com.bioquinvel.backend.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.bioquinvel.backend.models.entities.LineaPedido;

public interface ILineaPedidoService {
	
	public void save(LineaPedido lineaPedido);
	public Optional<LineaPedido> findById(Integer id);
	public void delete(Integer id);
	public List<LineaPedido> findAll();
}
