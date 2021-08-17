package com.bioquinvel.backend.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bioquinvel.backend.models.entities.Cliente;


public interface ICliente extends JpaRepository<Cliente, Integer>{

}
