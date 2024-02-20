package com.application.controllers;

import com.application.helpers.JwtHelper;
import com.application.services.auth.AuthService;
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
    @PostMapping("/auth")
    public String login(@RequestBody Object request) {

        String token = JwtHelper.generateToken("admin");
        return token;
    }
}