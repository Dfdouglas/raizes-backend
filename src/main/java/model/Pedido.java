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

    // Status do pedido (ex: RECEBIDO, PREPARANDO, FINALIZADO)
    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    // Canal de onde veio o pedido (APP, BALCAO, TOTEM, WEB)
    @Enumerated(EnumType.STRING)
    private CanalPedido canal;

    // Relacionamento com usuário (quem fez o pedido)
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // GETTERS E SETTERS

    public Long getId() {
        return id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public CanalPedido getCanal() {
        return canal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public void setCanal(CanalPedido canal) {
        this.canal = canal;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}