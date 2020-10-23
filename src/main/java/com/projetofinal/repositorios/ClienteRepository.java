package com.projetofinal.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetofinal.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
