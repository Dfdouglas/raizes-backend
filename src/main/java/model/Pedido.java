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
    private StatusPedido status;

    // Canal de origem do pedido
    // Ex: APP, TOTEM, BALCAO, PICKUP, WEB
    @Enumerated(EnumType.STRING)
    private CanalPedido canalPedido;

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