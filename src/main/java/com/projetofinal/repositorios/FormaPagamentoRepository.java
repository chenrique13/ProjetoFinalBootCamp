package com.projetofinal.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetofinal.domain.FormaPagamento;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Integer>{

	List<FormaPagamento> findAllByOrderByIdAsc(); 
}
