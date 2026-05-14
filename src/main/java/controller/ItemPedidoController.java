package com.raizes.backend.controller;

import com.raizes.backend.model.ItemPedido;
import com.raizes.backend.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller responsável pelos endpoints dos itens de pedido
@RestController
@RequestMapping("/itens")
public class ItemPedidoController {

    // O controller chama o service.
    // O service é quem faz as validações e acessa o banco.
    @Autowired
    private ItemPedidoService service;

    // Criar item do pedido com validação de pedido e produto
    @PostMapping
    public ItemPedido criar(@RequestBody ItemPedido item) {
        return service.criar(item);
    }

    // Listar todos os itens cadastrados
    @GetMapping
    public List<ItemPedido> listar() {
        return service.listar();
    }
}