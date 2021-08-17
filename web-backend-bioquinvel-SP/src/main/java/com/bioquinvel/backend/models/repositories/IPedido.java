package com.bioquinvel.backend.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bioquinvel.backend.models.entities.Pedido;

public interface IPedido extends JpaRepository<Pedido, Integer> {

}
