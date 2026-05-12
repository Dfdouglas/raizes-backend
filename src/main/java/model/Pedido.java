package com.raizes.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

// Entidade que representa um pedido feito no sistema
@Entity
@Table(name = "pedidos")
public class Pedido {

    // Identificador único do pedido
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Data e hora em que o pedido foi criado
    private LocalDateTime dataHora = LocalDateTime.now();

    // Status atual do pedido
    // Ex: RECEBIDO, PREPARANDO, FINALIZADO, CANCELADO
    @Enumerated(EnumType.STRING)
    private com.raizes.backend.model.StatusPedido status;

    // Canal de origem do pedido
    // Ex: APP, TOTEM, BALCAO, PICKUP, WEB
    @Enumerated(EnumType.STRING)
    private com.raizes.backend.model.CanalPedido canalPedido;

    // Usuário que realizou o pedido
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

    public com.raizes.backend.model.StatusPedido getStatus() {
        return status;
    }

    public com.raizes.backend.model.CanalPedido getCanalPedido() {
        return canalPedido;
    }

    public com.raizes.backend.model.Usuario getUsuario() {
        return usuario;
    }

    // SETTERS

    public void setId(Long id) {
        this.id = id;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public void setStatus(com.raizes.backend.model.StatusPedido status) {
        this.status = status;
    }

    public void setCanalPedido(com.raizes.backend.model.CanalPedido canalPedido) {
        this.canalPedido = canalPedido;
    }

    public void setUsuario(com.raizes.backend.model.Usuario usuario) {
        this.usuario = usuario;
    }
}