package com.bioquinvel.backend.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bioquinvel.backend.models.entities.Producto;

public interface IProducto extends CrudRepository<Producto, Integer>{

}