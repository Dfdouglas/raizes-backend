package com.raizes.backend.controller;

import com.raizes.backend.model.Pedido;
import com.raizes.backend.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller responsável pelos pedidos
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    // 🔹 Criar pedido
    @PostMapping
    public Pedido criar(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    // 🔹 Listar pedidos
    @GetMapping
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }
}