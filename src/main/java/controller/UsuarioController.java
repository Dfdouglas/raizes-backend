package com.raizes.backend.controller;

import com.raizes.backend.model.Usuario;
import com.raizes.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Controller responsável pelo cadastro e login de usuários
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Lista usuários cadastrados
    @GetMapping
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    // Cadastra usuário com senha criptografada
    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario) {

        // Criptografa a senha antes de salvar no banco
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));

        return usuarioRepository.save(usuario);
    }

    // Login simples: confere e-mail e senha
    @PostMapping("/login")
    public String login(@RequestBody Usuario usuarioLogin) {

        Optional<Usuario> usuarioEncontrado = usuarioRepository.findByEmail(usuarioLogin.getEmail());

        if (usuarioEncontrado.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado");
        }

        Usuario usuario = usuarioEncontrado.get();

        boolean senhaCorreta = passwordEncoder.matches(usuarioLogin.getSenha(), usuario.getSenha());

        if (!senhaCorreta) {
            throw new RuntimeException("Senha inválida");
        }

        return "Login realizado com sucesso! Perfil: " + usuario.getPerfil();
    }
}