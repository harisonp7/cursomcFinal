package com.harison.cursomc.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harison.cursomc.domain.Categoria;
import com.harison.cursomc.repositories.Services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
		@Autowired
		private CategoriaService service;

		 
		@GetMapping("/{id}") 
			//@RequestMapping(value="/{id}", method=RequestMethod.GET)
			//@PathVariable = Pegar o id e passar adiante no metodo buscar.
		public ResponseEntity<?> find(@PathVariable Integer id) {
			
			Optional<Categoria> obj = service.Buscar(id);
			return ResponseEntity.ok().body(obj);
			
		}
}
