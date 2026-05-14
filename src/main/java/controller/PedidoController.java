package com.raizes.backend.controller;

import com.raizes.backend.dto.AtualizarStatusPedidoDTO;
import com.raizes.backend.model.CanalPedido;
import com.raizes.backend.model.Pedido;
import com.raizes.backend.model.Perfil;
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

        String email = authentication.getName();

        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        pedido.setUsuario(usuario);

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

    // Atualizar status do pedido
    @PutMapping("/{id}/status")
    public Pedido atualizarStatus(
            @PathVariable Long id,
            @RequestBody AtualizarStatusPedidoDTO dto,
            Authentication authentication
    ) {

        String email = authentication.getName();

        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Apenas ADMIN, GERENTE, ATENDENTE ou COZINHA podem alterar status
        if (
                usuario.getPerfil() != Perfil.ADMIN &&
                        usuario.getPerfil() != Perfil.GERENTE &&
                        usuario.getPerfil() != Perfil.ATENDENTE &&
                        usuario.getPerfil() != Perfil.COZINHA
        ) {
            throw new RuntimeException("Usuário sem permissão para atualizar status do pedido");
        }

        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        if (dto.getStatus() == null) {
            throw new RuntimeException("Status do pedido é obrigatório");
        }

        pedido.setStatus(dto.getStatus());

        return pedidoRepository.save(pedido);
    }
}