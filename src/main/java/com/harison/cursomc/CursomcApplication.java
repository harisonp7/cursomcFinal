package com.harison.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.harison.cursomc.domain.Categoria;
import com.harison.cursomc.domain.Cidade;
import com.harison.cursomc.domain.Cliente;
import com.harison.cursomc.domain.Endereco;
import com.harison.cursomc.domain.Estado;
import com.harison.cursomc.domain.Produto;
import com.harison.cursomc.enums.TipoCliente;
import com.harison.cursomc.repositories.CategoriaRepository;
import com.harison.cursomc.repositories.CidadeRepository;
import com.harison.cursomc.repositories.ClienteRepository;
import com.harison.cursomc.repositories.EnderecoRepository;
import com.harison.cursomc.repositories.EstadoRepository;
import com.harison.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;


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
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2, cat3));
		
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		
		//Associando os estados para as cidades
		Cidade c1 = new Cidade(null, "Uberlãndia",est1);
		Cidade c2 = new Cidade(null, "São Paulo",est2);
		Cidade c3 = new Cidade(null, "Campinas",est2);
	
		//Associando as cidades nos estados
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
	
		
		
		//salvar primeiro o cliente
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "33933946805", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("991744100", "993624800"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Ap 203", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Av matos", "105", "Sala 800", "Centro", "338777012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
	}

}
