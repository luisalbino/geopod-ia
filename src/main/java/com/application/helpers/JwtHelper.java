package com.application.helpers;

import com.application.config.ApplicationProperties;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

public class JwtHelper {

    private final HttpServletRequest request;

    private String username = "";
    private String secret = "";

    public JwtHelper(ApplicationProperties applicationProperties, HttpServletRequest request) {
        this.request = request;

        username = applicationProperties.getUsuarioLogin();
        secret = applicationProperties.getAutenticacaoSecret();
    }

    public String generateToken() {

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        byte[] apiKeySecretBytes = Base64.getEncoder().encode(this.secret.getBytes());
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());

        String token = Jwts.builder()
                .setSubject(this.username)
                .setIssuedAt(now)
                .setExpiration(new Date(nowMillis + 3600000)) // expira em 1 hora
                .signWith(SignatureAlgorithm.HS256, signingKey)
                .compact();

        HttpSession session = this.request.getSession();
        session.setAttribute("geoToken", token);

        return token;
    }

    public boolean tokenIsValid(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(this.secret.getBytes())
                .parseClaimsJws(token.strip())
                .getBody();

        Date expirationDate = claims.getExpiration();
        return expirationDate != null && expirationDate.after(new Date());
    }
}
