package com.bioquinvel.backend.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.bioquinvel.backend.models.entities.Pedido;


public interface IPedidoService {
	public void save(Pedido v);
	public Optional<Pedido> findById(Integer id);
	public void delete(Integer id);
	public List<Pedido> findAll();
}
