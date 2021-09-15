package com.bioquinvel.backend.models.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.bioquinvel.backend.models.entities.Administrativo;

public interface IAdministrativoService {
	
	public void save(Administrativo administrativo);
	public Optional<Administrativo> findById(Integer id);
	public void delete(Integer id);
	public List<Administrativo> findAll();
	public Administrativo findByemail_admin(String u);
}
