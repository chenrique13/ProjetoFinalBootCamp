package com.projetofinal.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetofinal.domain.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {

	List<Fornecedor> findAllByOrderByIdAsc(); 
}
