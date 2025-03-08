package com.harison.cursomc.repositories.Services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harison.cursomc.domain.Categoria;
import com.harison.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Optional<Categoria> Buscar(Integer id) {
	
		Optional<Categoria> obj = repo.findById(id);
		//return Optional.ofNullable(obj.orElse(null));
		
		return obj.map(Optional::ofNullable).orElse(Optional.empty());
		
	}

}
