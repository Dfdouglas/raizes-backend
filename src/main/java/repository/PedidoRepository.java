package com.raizes.backend.repository;

import com.raizes.backend.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

// Acesso ao banco para pedidos
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}