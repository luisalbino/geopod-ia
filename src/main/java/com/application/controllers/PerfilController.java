package com.application.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/perfil")
@RestController
public class PerfilController {

    /*
    * Método para listar todos os perfis
    */
    @GetMapping("/list")
    public ResponseEntity<?> getPerfilList() {
        try {
            return ResponseEntity.ok("ok");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro interno.");
        }
    }

    /*
     * Método para retornar as informações de um perfil
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getPerfilById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok("ok perfil: " + id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro interno.");
        }
    }

    /*
     * Método para listar todos os sql's relacionados ao perfil
     */
    @GetMapping("/{id}/sql")
    public ResponseEntity<?> getPerfilSql(@PathVariable Long id) {
        try {
            return ResponseEntity.ok("ok perfil: " + id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro interno.");
        }
    }
}
