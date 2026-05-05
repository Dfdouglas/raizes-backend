package com.raizes.backend.model;

import jakarta.persistence.*;

// Essa classe representa os itens dentro de um pedido.
// Exemplo: um pedido pode ter 2 X-Burgers e 1 Suco.
@Entity
@Table(name = "itens_pedido")
public class ItemPedido {

    // ID único do item do pedido
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Quantidade do produto no pedido
    // Ex: 2 hambúrgueres, 3 refrigerantes
    private Integer quantidade;

    // Relacionamento com Pedido
    // Muitos itens pertencem a UM pedido
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    // Relacionamento com Produto
    // Muitos itens podem ter o MESMO produto
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    // =========================
    // GETTERS
    // =========================

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

    // =========================
    // SETTERS
    // =========================

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