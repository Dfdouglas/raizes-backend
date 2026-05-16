package com.raizes.backend.repository;

import com.raizes.backend.model.Auditoria;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository responsável pela tabela de auditoria
public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> {
}