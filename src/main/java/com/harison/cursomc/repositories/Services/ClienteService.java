package com.harison.cursomc.repositories.Services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harison.cursomc.domain.Cliente;
import com.harison.cursomc.repositories.ClienteRepository;
import com.harison.cursomc.repositories.Services.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Optional<Cliente> Buscar(Integer id) {
	
		Optional<Cliente> obj = repo.findById(id);	
		if (obj.isEmpty()) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()); //Enviando um exception, Resource precisa capturar a exception
		}
		return obj;
		
	}
}
