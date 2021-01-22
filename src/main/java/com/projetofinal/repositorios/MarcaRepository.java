package com.projetofinal.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetofinal.domain.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Integer>{

	List<Marca> findAllByOrderByIdAsc(); 
}
