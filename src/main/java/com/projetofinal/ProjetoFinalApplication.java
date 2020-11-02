package com.projetofinal;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projetofinal.domain.Categoria;
import com.projetofinal.domain.Cliente;
import com.projetofinal.domain.Faq;
import com.projetofinal.domain.FormaPagamento;
import com.projetofinal.domain.Fornecedor;
import com.projetofinal.domain.ItensVenda;
import com.projetofinal.domain.Marca;
import com.projetofinal.domain.Produto;
import com.projetofinal.domain.Venda;
import com.projetofinal.repositorios.CategoriaRepository;
import com.projetofinal.repositorios.ClienteRepository;
import com.projetofinal.repositorios.FaqRepository;
import com.projetofinal.repositorios.FormaPagamentoRepository;
import com.projetofinal.repositorios.FornecedorRepository;
import com.projetofinal.repositorios.ItensVendaRepository;
import com.projetofinal.repositorios.MarcaRepository;
import com.projetofinal.repositorios.ProdutoRepository;
import com.projetofinal.repositorios.VendaRepository;

@SpringBootApplication
public class ProjetoFinalApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository repositorioCategoria;

	@Autowired
	private ClienteRepository repositorioCliente;

	@Autowired
	private FaqRepository repositorioFaq;

	@Autowired
	private FormaPagamentoRepository repositorioFormaPagamento;

	@Autowired
	private FornecedorRepository repositorioFornecedor;

	@Autowired
	private ItensVendaRepository repositorioItensvenda;

	@Autowired
	private MarcaRepository repositorioMarca;

	@Autowired
	private ProdutoRepository repositorioProduto;

	@Autowired
	private VendaRepository repositorioVenda;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoFinalApplication.class, args);
	}

	/**
	 * Metodo para Preecher o Banco de dados
	 * 
	 * @author Cícero Junior
	 */
	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Cliente cliente1 = new Cliente(null, "Carlos", "10193232444", "c.henrique13@gmail.com",
				data.parse("13/09/1994 10:15"), "Masculino", null, "Carlinhos", "985740926");
		Cliente cliente2 = new Cliente(null, "Cicero", "12325618910", "cirerooliveira@gmail.com",
				data.parse("05/07/1989 07:00"), "Masculino", null, "Ciço", "912345678");

		repositorioCliente.saveAll(Arrays.asList(cliente1, cliente2));

		FormaPagamento formaPg1 = new FormaPagamento(null, "Cartão", "Pagamento em 2 vezes", true);
		FormaPagamento formaPg2 = new FormaPagamento(null, "Boleto", "Pagamento em 1 vez", true);

		repositorioFormaPagamento.saveAll(Arrays.asList(formaPg1, formaPg2));

		Categoria categoria1 = new Categoria(null, "Livro", true);
		Categoria categoria2 = new Categoria(null, "Informática", true);

		Marca marca1 = new Marca(null, "Cia do Livro", "Editora");
		Marca marca2 = new Marca(null, "Positivo", "Tecnologia");

		Fornecedor fornecedor1 = new Fornecedor(null, "TI Brasil", "Rua 4, 12", "81 99985-5210", "12.345.789/0001-00",
				"vendas@tibrasil.com");

		Fornecedor fornecedor2 = new Fornecedor(null, "Edit Mais", "Rua Fg, 812", "88 87465-65201",
				"987.654.271/0001-09", "vendas@editmais.com");

		Produto produto1 = new Produto(null, "Computador", "HP-123", 1421.00, 1, categoria2, marca2, fornecedor1);
		Produto produto2 = new Produto(null, "Livro Didático", "ABACO", 21.00, 2, categoria1, marca1, fornecedor2);

		repositorioCategoria.saveAll(Arrays.asList(categoria1, categoria2));
		repositorioMarca.saveAll(Arrays.asList(marca1, marca2));
		repositorioFornecedor.saveAll(Arrays.asList(fornecedor1, fornecedor2));
		repositorioProduto.saveAll(Arrays.asList(produto1, produto2));

		Faq faq1 = new Faq(null, data.parse("27/10/2020 19:51"), "Muito bom!", produto2);
		Faq faq2 = new Faq(null, data.parse("10/12/2019 16:30"), "Produto de Excelente qualidade", produto1);

		repositorioFaq.saveAll(Arrays.asList(faq1, faq2));

		Venda venda1 = new Venda(null, data.parse("25/06/2019 19:25"), 1421.00, cliente1, formaPg1);
		Venda venda2 = new Venda(null, data.parse("25/06/2019 19:25"), 21.00, cliente2, formaPg2);

		repositorioVenda.saveAll(Arrays.asList(venda1, venda2));

		ItensVenda itens1 = new ItensVenda(null, 2, 2 * produto1.getPreco(), produto1, venda1);
		ItensVenda itens2 = new ItensVenda(null, 1, produto2.getPreco(), produto2, venda2);

		repositorioItensvenda.saveAll(Arrays.asList(itens1, itens2));
	}

}
