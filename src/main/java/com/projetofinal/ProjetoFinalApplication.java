package com.projetofinal;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projetofinal.domain.Categoria;
import com.projetofinal.domain.Cliente;
import com.projetofinal.domain.Produto;
import com.projetofinal.repositorios.CategoriaRepository;
import com.projetofinal.repositorios.ClienteRepository;
import com.projetofinal.repositorios.ProdutoRepository;

@SpringBootApplication
public class ProjetoFinalApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository repositorioCliente;
	
	@Autowired
	private CategoriaRepository repositorioCategoria;
	
	@Autowired
	private ProdutoRepository repositorioProduto;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoFinalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Cliente cliente1 = new Cliente(null, "Carlos","10197932444", "c.henrique13@gmail.com", null, null, null, null, "985740926");
		Cliente cliente2 = new Cliente(null, "Cicero","12345678910", "cirerooliveira@gmail.com", null, null, null, null, "912345678");
		
		repositorioCliente.saveAll(Arrays.asList(cliente1, cliente2));
		
		Categoria cat1 = new Categoria(null,"Livro", true);
		Categoria cat2 = new Categoria(null,"Informática", true);
	
						
		Produto p1 = new Produto (null, "Computador", "HP-123", 1421.00, 1, cat2);
		Produto p2 = new Produto (null, "Livro Didático", "ABACO", 21.00, 2, cat1);
				
		
		cat1.getProdutos().addAll(Arrays.asList(p2));
		cat2.getProdutos().addAll(Arrays.asList(p1));
		
		repositorioCategoria.saveAll(Arrays.asList(cat1, cat2));		
		repositorioProduto.saveAll(Arrays.asList(p1, p2));
		
	}

}
