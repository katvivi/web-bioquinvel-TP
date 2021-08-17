package com.bioquinvel.backend.models.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bioquinvel.backend.models.entities.Administrativo;
import com.bioquinvel.backend.models.repositories.IAdministrativo;
import com.bioquinvel.backend.models.service.interfaces.IAdministrativoService;

@Service
public class AdministrativoService implements IAdministrativoService {
	
	@Autowired	
	IAdministrativo repository; 
		
	@Override
	@Transactional
	public void save(Administrativo administrativo) {
		repository.save(administrativo);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Administrativo> findById(Integer id) {		
		return repository.findById(id);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		repository.deleteById(id);				
	}

	@Override
	@Transactional(readOnly=true)
	public List<Administrativo> findAll() {		
		return (List<Administrativo>) repository.findAll();
	}
}
