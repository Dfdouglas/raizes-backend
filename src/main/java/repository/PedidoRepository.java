package com.raizes.backend.repository;

import com.raizes.backend.model.CanalPedido;
import com.raizes.backend.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Repository responsável pelo acesso ao banco da tabela pedidos
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // Busca pedidos filtrando pelo canal de origem
    List<Pedido> findByCanalPedido(CanalPedido canalPedido);
}