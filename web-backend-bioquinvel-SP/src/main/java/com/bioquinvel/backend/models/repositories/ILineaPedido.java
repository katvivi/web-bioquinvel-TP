package com.bioquinvel.backend.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bioquinvel.backend.models.entities.LineaPedido;

public interface ILineaPedido extends CrudRepository<LineaPedido, Integer> {

}
