package com.raizes.backend.repository;


import com.raizes.backend.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository responsável pelo acesso ao banco da tabela pagamentos
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}