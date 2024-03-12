package com.application.controllers;

import com.application.config.ApplicationProperties;
import com.application.helpers.JwtHelper;
import com.application.models.UserModel;
import com.application.models.controller.TokenResponseModel;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class AuthController {

    private final ApplicationProperties applicationProperties;

    private final JwtHelper jwtHelper;

    @Autowired
    public AuthController(ApplicationProperties applicationProperties, HttpServletRequest request) {
        this.applicationProperties = applicationProperties;
        this.jwtHelper = new JwtHelper(this.applicationProperties, request);
    }

    @PostMapping("/auth")
    public ResponseEntity<TokenResponseModel> login(@RequestBody UserModel user) {
        try {
            if (user.getUsername().equals(applicationProperties.getUsuarioLogin()) && user.getPassword().equals(applicationProperties.getUsuarioSenha())) {
                return ResponseEntity.ok(new TokenResponseModel(HttpStatus.OK.value(), "Token recuperado com sucesso!", this.jwtHelper.generateToken()));
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TokenResponseModel(HttpStatus.UNAUTHORIZED.value(), "Usuário ou senha incorreta.", null));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TokenResponseModel(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ocorreu um erro interno.", null));
        }
    }
}