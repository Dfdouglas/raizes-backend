package com.raizes.backend.controller;

import com.raizes.backend.model.CanalPedido;
import com.raizes.backend.model.Pedido;
import com.raizes.backend.model.Usuario;
import com.raizes.backend.repository.PedidoRepository;
import com.raizes.backend.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller responsável pelos endpoints de pedidos
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Criar pedido
    @PostMapping
    public Pedido criar(
            @RequestBody Pedido pedido,
            Authentication authentication
    ) {

        // pega email do usuário logado
        String email = authentication.getName();

        // busca usuário no banco
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // vincula usuário automaticamente
        pedido.setUsuario(usuario);

        // salva pedido
        return pedidoRepository.save(pedido);
    }

    // Listar pedidos
    @GetMapping
    public List<Pedido> listar(@RequestParam(required = false) CanalPedido canalPedido) {

        if (canalPedido != null) {
            return pedidoRepository.findByCanalPedido(canalPedido);
        }

        return pedidoRepository.findAll();
    }
}