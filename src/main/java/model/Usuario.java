package com.raizes.backend.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

// Indica que esta classe representa uma tabela no banco de dados
@Entity

// Define o nome da tabela que será criada no PostgreSQL
@Table(name = "usuarios")
public class Usuario {

    // Chave primária da tabela
    @Id

    // Gera o ID automaticamente no banco
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome do usuário
    private String nome;

    // E-mail usado para login e identificação
    private String email;

    // Senha do usuário
    // Futuramente essa senha deve ser salva com hash, não em texto puro
    @JsonIgnore
    private String senha;

    // Perfil do usuário no sistema
    // Exemplo: CLIENTE, ATENDENTE, COZINHA, GERENTE ou ADMIN
    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    // GETTERS E SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}