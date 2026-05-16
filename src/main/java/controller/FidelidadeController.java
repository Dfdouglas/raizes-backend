package com.raizes.backend.controller;

import com.raizes.backend.model.Fidelidade;
import com.raizes.backend.repository.FidelidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller responsável pelos pontos de fidelidade
@RestController
@RequestMapping("/fidelidade")
public class FidelidadeController {

    @Autowired
    private FidelidadeRepository repository;

    // Lista todos os registros de fidelidade
    @GetMapping
    public List<Fidelidade> listar() {
        return repository.findAll();
    }
}