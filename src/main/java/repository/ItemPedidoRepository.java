package com.raizes.backend.repository;

import com.raizes.backend.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

// Acesso ao banco para itens do pedido
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}