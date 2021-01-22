package com.projetofinal.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetofinal.domain.ItensVenda;

public interface ItensVendaRepository extends JpaRepository<ItensVenda, Integer>{

	List<ItensVenda> findAllByOrderByIdAsc(); 
}
