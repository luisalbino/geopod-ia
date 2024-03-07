package com.application.controllers;

import com.application.entities.importador.PerfilEntity;
import com.application.models.controller.ResponseModel;
import com.application.services.importador.PerfilService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/perfil")
@RestController
public class PerfilController {

    private final PerfilService perfilService;

    public PerfilController(PerfilService perfilService) {
        this.perfilService = perfilService;
    }

    /*
    * Método para listar todos os perfis
    */
    @GetMapping("/all")
    public ResponseEntity<ResponseModel<PerfilEntity>> getAll() {
        try {
            return ResponseEntity.ok(new ResponseModel<>(HttpStatus.OK.value(), "", perfilService.getAll()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseModel<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "", null));
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
