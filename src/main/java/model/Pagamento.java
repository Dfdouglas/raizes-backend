package com.raizes.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

// Representa o registro de pagamento de um pedido.
// Neste projeto, o pagamento será simulado, ou seja, mock.
@Entity
@Table(name = "pagamentos")
public class Pagamento {

    // ID único do pagamento
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Data e hora em que o pagamento foi registrado
    private LocalDateTime dataPagamento = LocalDateTime.now();

    // Status do pagamento: APROVADO ou RECUSADO
    @Enumerated(EnumType.STRING)
    private StatusPagamento status;

    // Relacionamento com Pedido
    // Um pagamento pertence a um pedido
    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    // GETTERS E SETTERS

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