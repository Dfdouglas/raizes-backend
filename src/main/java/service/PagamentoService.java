package com.raizes.backend.service;

import com.raizes.backend.model.Pagamento;
import com.raizes.backend.model.Pedido;
import com.raizes.backend.model.StatusPagamento;
import com.raizes.backend.model.StatusPedido;
import com.raizes.backend.repository.PagamentoRepository;
import com.raizes.backend.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Camada de regra de negócio do pagamento
@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    // Simula o pagamento de um pedido
    public Pagamento pagar(Long pedidoId, boolean aprovado) {

        // Busca o pedido no banco
        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        // Cria um novo registro de pagamento
        Pagamento pagamento = new Pagamento();

        // Relaciona o pagamento ao pedido encontrado
        pagamento.setPedido(pedido);

        // Se aprovado, aprova pagamento e finaliza pedido
        if (aprovado) {
            pagamento.setStatus(StatusPagamento.APROVADO);
            pedido.setStatus(StatusPedido.FINALIZADO);
        } else {
            pagamento.setStatus(StatusPagamento.RECUSADO);
            pedido.setStatus(StatusPedido.CANCELADO);
        }

        // Atualiza o status do pedido no banco
        pedidoRepository.save(pedido);

        // Salva o pagamento no banco
        return pagamentoRepository.save(pagamento);
    }
}