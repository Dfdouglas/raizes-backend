package com.raizes.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

// Entidade que representa um pedido feito no sistema
@Entity
@Table(name = "pedidos")
public class Pedido {

    // ID do pedido
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Data e hora que o pedido foi criado
    private LocalDateTime dataHora = LocalDateTime.now();

    // Status do pedido: RECEBIDO, PREPARANDO, PRONTO, FINALIZADO ou CANCELADO
    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    // Canal de origem do pedido: APP, TOTEM, BALCAO, PICKUP ou WEB
    @Enumerated(EnumType.STRING)
    private CanalPedido canalPedido;

    // Relacionamento com usuário que fez o pedido
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // GETTERS

    public Long getId() {
        return id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public CanalPedido getCanalPedido() {
        return canalPedido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    // SETTERS

    public void setId(Long id) {
        this.id = id;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public void setCanalPedido(CanalPedido canalPedido) {
        this.canalPedido = canalPedido;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}