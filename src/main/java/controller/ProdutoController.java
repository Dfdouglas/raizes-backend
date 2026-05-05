package com.raizes.backend.controller;

import com.raizes.backend.model.Produto;
import com.raizes.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Essa classe cria as rotas da API para Produto
@RestController

// Define o caminho base da API → http://localhost:8080/produtos
@RequestMapping("/produtos")
public class ProdutoController {

    // Injeta automaticamente o repository (acesso ao banco)
    @Autowired
    private ProdutoRepository produtoRepository;

    // 🔹 LISTAR TODOS PRODUTOS
    // GET → /produtos
    @GetMapping
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    // 🔹 CRIAR PRODUTO
    // POST → /produtos
    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }
}