package com.harison.cursomc;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.harison.cursomc.domain.Categoria;
import com.harison.cursomc.domain.Produto;
import com.harison.cursomc.repositories.CategoriaRepository;
import com.harison.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepositoriy;
	
	@Autowired
	private ProdutoRepository produtoRepositoriy;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria (null, "Informátiva");
		Categoria cat2 = new Categoria (null, "Escritório");
		Categoria cat3 = new Categoria (null, "Monitor");
		
		Produto p1 = new Produto (null, "Computador", 2000.00);
		Produto p2 = new Produto (null, "Impressora", 800.00);
		Produto p3 = new Produto (null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3)); //Porque uso o get e nao o set ? Porque preciso atualizar a lista já existente.
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepositoriy.saveAll(Arrays.asList(cat1,cat2, cat3));
		
		produtoRepositoriy.saveAll(Arrays.asList(p1,p2,p3));
	}

}
