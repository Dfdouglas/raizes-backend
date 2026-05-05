package com.raizes.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

// Classe que trata erros da aplicação e retorna resposta bonita
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Trata erros genéricos (RuntimeException)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException ex) {

        Map<String, Object> erro = new HashMap<>();
        erro.put("mensagem", ex.getMessage());
        erro.put("status", 400);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}