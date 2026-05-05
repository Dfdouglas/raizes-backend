package com.raizes.backend.repository;

import com.raizes.backend.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface que permite acessar o banco (CRUD automático)
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}