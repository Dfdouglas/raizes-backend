package com.raizes.backend.controller;

import com.raizes.backend.model.CanalPedido;
import com.raizes.backend.model.Pedido;
import com.raizes.backend.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller responsável pelos endpoints de pedidos
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    // Criar pedido
    @PostMapping
    public Pedido criar(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    // Listar pedidos
    // Exemplo sem filtro: GET /pedidos
    // Exemplo com filtro: GET /pedidos?canalPedido=APP
    @GetMapping
    public List<Pedido> listar(@RequestParam(required = false) CanalPedido canalPedido) {

        if (canalPedido != null) {
            return pedidoRepository.findByCanalPedido(canalPedido);
        }

        return pedidoRepository.findAll();
    }
}