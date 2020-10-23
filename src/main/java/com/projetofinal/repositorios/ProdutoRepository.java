package com.projetofinal.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetofinal.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
