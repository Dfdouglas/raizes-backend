package com.raizes.backend.controller;

import com.raizes.backend.model.Auditoria;
import com.raizes.backend.model.Pagamento;
import com.raizes.backend.repository.AuditoriaRepository;
import com.raizes.backend.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

// Controller responsável pelos endpoints de pagamento
@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    // Simular pagamento aprovado
    @PostMapping("/pedido/{pedidoId}/aprovar")
    public Pagamento aprovar(
            @PathVariable Long pedidoId,
            Authentication authentication
    ) {
        Pagamento pagamento = service.pagar(pedidoId, true);

        salvarAuditoria(
                "APROVAR_PAGAMENTO",
                authentication,
                "Pagamento aprovado para o pedido ID " + pedidoId
        );

        return pagamento;
    }

    // Simular pagamento recusado
    @PostMapping("/pedido/{pedidoId}/recusar")
    public Pagamento recusar(
            @PathVariable Long pedidoId,
            Authentication authentication
    ) {
        Pagamento pagamento = service.pagar(pedidoId, false);

        salvarAuditoria(
                "RECUSAR_PAGAMENTO",
                authentication,
                "Pagamento recusado para o pedido ID " + pedidoId
        );

        return pagamento;
    }

    // Método auxiliar para registrar auditoria
    private void salvarAuditoria(
            String acao,
            Authentication authentication,
            String detalhes
    ) {
        Auditoria auditoria = new Auditoria();

        auditoria.setAcao(acao);
        auditoria.setUsuario(authentication.getName());
        auditoria.setDataHora(LocalDateTime.now());
        auditoria.setDetalhes(detalhes);

        auditoriaRepository.save(auditoria);
    }
}