package com.raizes.backend.model;

import jakarta.persistence.*;

// Entidade responsável pelos pontos de fidelidade do usuário
@Entity
@Table(name = "fidelidade")
public class Fidelidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Usuário dono da pontuação
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // Quantidade de pontos acumulados
    private Integer pontos;

    // GETTERS E SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }
}