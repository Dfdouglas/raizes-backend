package com.raizes.backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

// Entidade que representa os produtos do cardápio
@Entity
@Table(name = "produtos")
public class Produto {

    // Chave primária da tabela produtos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome do produto
    private String nome;

    // Descrição do produto
    private String descricao;

    // Preço do produto
    private BigDecimal preco;

    // Define se o produto está ativo no cardápio
    private Boolean ativo = true;

    // Quantidade disponível em estoque
    private Integer quantidadeEstoque;

    // GETTERS

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    // SETTERS

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}