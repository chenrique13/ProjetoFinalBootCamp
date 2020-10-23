package com.projetofinal;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projetofinal.domain.Cliente;
import com.projetofinal.repositorios.ClienteRepository;

@SpringBootApplication
public class ProjetoFinalApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository repositorioCliente;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoFinalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Cliente cliente1 = new Cliente(null, "Carlos","10197932444", "c.henrique13@gmail.com", null, null, null, null, "985740926");
		Cliente cliente2 = new Cliente(null, "Cicero","12345678910", "cirerooliveira@gmail.com", null, null, null, null, "912345678");
		
		repositorioCliente.saveAll(Arrays.asList(cliente1, cliente2));
	}

}
