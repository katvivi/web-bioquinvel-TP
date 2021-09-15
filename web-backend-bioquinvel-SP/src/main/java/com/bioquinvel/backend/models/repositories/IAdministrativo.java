package com.bioquinvel.backend.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bioquinvel.backend.models.entities.Administrativo;


public interface IAdministrativo extends CrudRepository<Administrativo, Integer> {
	@Query("SELECT U FROM Administrativo U WHERE U.emailAdmin = :u")
	public Administrativo findByemail_admin(String u);
}

