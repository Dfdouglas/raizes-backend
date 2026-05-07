package com.raizes.backend.model;

import jakarta.persistence.*;

// Essa classe representa os itens dentro de um pedido
@Entity
@Table(name = "itens_pedido")
public class ItemPedido {

    // ID do item
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Quantidade do produto
    private Integer quantidade;

    // Relacionamento com Pedido
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    // Relacionamento com Produto
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    // GETTERS

    public Long getId() {
        return id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    // SETTERS

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}