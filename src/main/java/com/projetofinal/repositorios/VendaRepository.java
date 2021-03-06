package com.projetofinal.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetofinal.domain.Venda;

public interface VendaRepository extends JpaRepository<Venda, Integer> {

	List<Venda> findAllByOrderByIdAsc(); 
}
