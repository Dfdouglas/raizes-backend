package com.raizes.backend.repository;

import com.raizes.backend.model.Fidelidade;
import com.raizes.backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Repository responsável pela tabela de fidelidade
public interface FidelidadeRepository extends JpaRepository<Fidelidade, Long> {

    Optional<Fidelidade> findByUsuario(Usuario usuario);
}