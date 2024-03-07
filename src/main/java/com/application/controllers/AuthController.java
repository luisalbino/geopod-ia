package com.application.controllers;

import com.application.helpers.JwtHelper;
import com.application.models.UserModel;
import com.application.models.controller.TokenResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class AuthController {
    @PostMapping("/auth")
    public ResponseEntity<TokenResponseModel> login(@RequestBody UserModel user) {
        try {
            String token = JwtHelper.generateToken(user.getUsername());
            return ResponseEntity.ok(new TokenResponseModel(HttpStatus.OK.value(), "Token recuperado com sucesso!", token));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TokenResponseModel(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ocorreu um erro interno.", null));
        }
    }
}