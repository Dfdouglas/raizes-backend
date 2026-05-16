package com.raizes.backend.controller;

import com.raizes.backend.model.Auditoria;
import com.raizes.backend.repository.AuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller responsável pelos logs de auditoria
@RestController
@RequestMapping("/auditorias")
public class AuditoriaController {

    @Autowired
    private AuditoriaRepository repository;

    // Listar logs de auditoria
    @GetMapping
    public List<Auditoria> listar() {
        return repository.findAll();
    }
}