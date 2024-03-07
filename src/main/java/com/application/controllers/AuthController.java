package com.application.controllers;

import com.application.helpers.JwtHelper;
import com.application.models.UserModel;
import com.application.models.controller.TokenResponseModel;
import com.application.services.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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