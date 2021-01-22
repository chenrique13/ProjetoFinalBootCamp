package com.projetofinal.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetofinal.domain.Faq;

public interface FaqRepository extends JpaRepository<Faq, Integer>{

	List<Faq> findAllByOrderByIdAsc(); 
}
