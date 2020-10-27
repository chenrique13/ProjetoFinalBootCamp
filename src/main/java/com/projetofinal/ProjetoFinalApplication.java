package com.projetofinal;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projetofinal.domain.Categoria;
import com.projetofinal.domain.Cliente;
import com.projetofinal.domain.Faq;
import com.projetofinal.domain.Fornecedor;
import com.projetofinal.domain.Marca;
import com.projetofinal.domain.Produto;
import com.projetofinal.repositorios.CategoriaRepository;
import com.projetofinal.repositorios.ClienteRepository;
import com.projetofinal.repositorios.FaqRepository;
import com.projetofinal.repositorios.FornecedorRepository;
import com.projetofinal.repositorios.MarcaRepository;
import com.projetofinal.repositorios.ProdutoRepository;

@SpringBootApplication
public class ProjetoFinalApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository repositorioCliente;

	@Autowired
	private CategoriaRepository repositorioCategoria;

	@Autowired
	private MarcaRepository repositorioMarca;

	@Autowired
	private ProdutoRepository repositorioProduto;

	@Autowired
	private FornecedorRepository repositorioFornecedor;

	@Autowired
	private FaqRepository repositorioFaq;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoFinalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Cliente cliente1 = new Cliente(null, "Carlos", "10197932444", "c.henrique13@gmail.com", null, null, null, null,
				"985740926");
		Cliente cliente2 = new Cliente(null, "Cicero", "12345678910", "cirerooliveira@gmail.com", null, null, null,
				null, "912345678");

		repositorioCliente.saveAll(Arrays.asList(cliente1, cliente2));

		Categoria cat1 = new Categoria(null, "Livro", true);
		Categoria cat2 = new Categoria(null, "Informática", true);

		Marca marca1 = new Marca(null, "Cia do Livro", "Editora");
		Marca marca2 = new Marca(null, "Positivo", "Tecnologia");

		Fornecedor fornecedor1 = new Fornecedor(null, "TI Brasil", "Rua 4, 12", "81 99985-5210", "12.345.789/0001-00",
				"vendas@tibrasil.com");

		Fornecedor fornecedor2 = new Fornecedor(null, "Edit Mais", "Rua Fg, 812", "88 87465-65201",
				"987.654.321/0001-09", "vendas@editmais.com");

		Produto p1 = new Produto(null, "Computador", "HP-123", 1421.00, 1, cat2, marca2, fornecedor1);
		Produto p2 = new Produto(null, "Livro Didático", "ABACO", 21.00, 2, cat1, marca1, fornecedor2);

		repositorioCategoria.saveAll(Arrays.asList(cat1, cat2));
		repositorioMarca.saveAll(Arrays.asList(marca1, marca2));
		repositorioFornecedor.saveAll(Arrays.asList(fornecedor1, fornecedor2));
		repositorioProduto.saveAll(Arrays.asList(p1, p2));

		Faq faq1 = new Faq(null, null, "Muito bom!",p2);
		Faq faq2 = new Faq(null, null, "Produto de Excelente qualidade",p1);

		repositorioFaq.saveAll(Arrays.asList(faq1, faq2));

	}

}
