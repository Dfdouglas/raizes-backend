package com.raizes.backend.controller;

import com.raizes.backend.model.Pagamento;
import com.raizes.backend.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller responsável pelos endpoints de pagamento
@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    // Simular pagamento aprovado
    @PostMapping("/pedido/{pedidoId}/aprovar")
    public Pagamento aprovar(@PathVariable Long pedidoId) {
        return service.pagar(pedidoId, true);
    }

    // Simular pagamento recusado
    @PostMapping("/pedido/{pedidoId}/recusar")
    public Pagamento recusar(@PathVariable Long pedidoId) {
        return service.pagar(pedidoId, false);
    }
}