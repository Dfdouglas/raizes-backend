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

    // Criar item com validação de pedido, produto e estoque
    public ItemPedido criar(ItemPedido item) {

        // Valida se pedido existe
        Pedido pedido = pedidoRepository.findById(item.getPedido().getId())
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        // Valida se produto existe
        Produto produto = produtoRepository.findById(item.getProduto().getId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        // Valida se a quantidade foi informada corretamente
        if (item.getQuantidade() == null || item.getQuantidade() <= 0) {
            throw new RuntimeException("Quantidade deve ser maior que zero");
        }

        // Valida se o produto tem estoque cadastrado
        if (produto.getQuantidadeEstoque() == null) {
            throw new RuntimeException("Produto sem estoque cadastrado");
        }

        // Valida se existe estoque suficiente para atender o pedido
        if (produto.getQuantidadeEstoque() < item.getQuantidade()) {
            throw new RuntimeException("Estoque insuficiente");
        }

        // Baixa o estoque do produto
        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - item.getQuantidade());

        // Salva o produto com o estoque atualizado
        produtoRepository.save(produto);

        // Garante integridade dos dados
        item.setPedido(pedido);
        item.setProduto(produto);

        // Salva o item no banco
        return itemRepository.save(item);
    }

    // Lista todos os itens cadastrados
    public List<ItemPedido> listar() {
        return itemRepository.findAll();
    }
}