package com.raizes.backend.repository;

import com.raizes.backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Repository responsável pelo acesso à tabela usuarios
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Busca usuário pelo e-mail, usado no login
    Optional<Usuario> findByEmail(String email);
}