package com.raizes.backend.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

// Classe responsável por tratar erros da aplicação
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Trata erros genéricos da aplicação
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRuntimeException(
            RuntimeException ex,
            HttpServletRequest request
    ) {

        Map<String, Object> erro = new HashMap<>();

        erro.put("timestamp", LocalDateTime.now());
        erro.put("status", 400);
        erro.put("error", "Bad Request");
        erro.put("message", ex.getMessage());
        erro.put("path", request.getRequestURI());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(erro);
    }
}