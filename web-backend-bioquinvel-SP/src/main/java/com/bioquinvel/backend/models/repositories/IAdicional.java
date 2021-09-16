package com.bioquinvel.backend.models.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bioquinvel.backend.models.entities.Adicional;

public interface IAdicional extends JpaRepository<Adicional, Integer> {
	public Optional<Adicional> findByCodigo(String codigo);

}
