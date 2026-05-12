package com.raizes.backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

// Entidade que representa o pagamento de um pedido
@Entity
@Table(name = "pagamentos")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataPagamento = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private StatusPagamento status;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public Long getId() {
        return id;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}