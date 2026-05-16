package com.raizes.backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

// Entidade responsável por registrar ações importantes do sistema
@Entity
@Table(name = "auditoria")
public class Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Ação realizada
    // Exemplo: CRIAR_PEDIDO, APROVAR_PAGAMENTO
    private String acao;

    // Usuário que realizou a ação
    private String usuario;

    // Data e hora do evento
    private LocalDateTime dataHora;

    // Detalhes adicionais
    @Column(columnDefinition = "TEXT")
    private String detalhes;

    // GETTERS E SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }
}