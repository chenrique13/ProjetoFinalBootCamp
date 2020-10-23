package com.projetofinal.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetofinal.domain.Cliente;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@RequestMapping (method = RequestMethod.GET)
	public List <Cliente> listar() {
		
		Cliente cli1 = new Cliente(1, "Carlos" , "10197932444", "c.henrique1309@gmail.com", null, "Masculino", null, null, "985740926" );
		
		List <Cliente> lista =  new ArrayList<Cliente>();
		lista.add(cli1);
		
		return lista;
	}
//	@RequestMapping (method = RequestMethod.GET)
//	public String lista() {
//		return "funcionando";
//	}
}
