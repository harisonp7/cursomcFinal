package com.harison.cursomc.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harison.cursomc.domain.Cliente;
import com.harison.cursomc.repositories.Services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	
		@Autowired
		private ClienteService service;

		 
		@GetMapping("/{id}") 
			//@RequestMapping(value="/{id}", method=RequestMethod.GET)
			//@PathVariable = Pegar o id e passar adiante no metodo buscar.
		public ResponseEntity<?> find(@PathVariable Integer id) { //Nao inserir try catch aqui. Indicado fazer um 
			
			Optional<Cliente> obj = service.Buscar(id);
			return ResponseEntity.ok().body(obj);
			
		}
}

