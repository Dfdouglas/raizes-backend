package com.raizes.backend.service;

import com.raizes.backend.model.ItemPedido;
import com.raizes.backend.model.Pedido;
import com.raizes.backend.model.Produto;
import com.raizes.backend.repository.ItemPedidoRepository;
import com.raizes.backend.repository.PedidoRepository;
import com.raizes.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Camada de regra de negócio dos itens do pedido
@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    // Criar item com validação
    public ItemPedido criar(ItemPedido item) {

        // Valida se pedido existe
        Pedido pedido = pedidoRepository.findById(item.getPedido().getId())
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        // Valida se produto existe
        Produto produto = produtoRepository.findById(item.getProduto().getId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        // Garante integridade dos dados
        item.setPedido(pedido);
        item.setProduto(produto);

        // Salva no banco
        return itemRepository.save(item);
    }

    // Lista todos os itens cadastrados
    public List<ItemPedido> listar() {
        return itemRepository.findAll();
    }
}