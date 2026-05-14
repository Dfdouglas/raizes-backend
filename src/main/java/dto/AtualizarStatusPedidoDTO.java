package com.raizes.backend.dto;

import com.raizes.backend.model.StatusPedido;

// DTO usado para atualizar status do pedido
public class AtualizarStatusPedidoDTO {

    private StatusPedido status;

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}