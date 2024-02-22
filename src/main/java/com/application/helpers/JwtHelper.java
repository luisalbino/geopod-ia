package com.application.helpers;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

public class JwtHelper {

    public static String generateToken(String username) {

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        String secretString = "aQw!2Dx#8fG@9pTkL5yS&bE$3jF*mV7n";
        byte[] apiKeySecretBytes = Base64.getEncoder().encode(secretString.getBytes());
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(new Date(nowMillis + 3600000)) // expira em 1 hora
                .signWith(SignatureAlgorithm.HS256, signingKey)
                .compact();
    }


    /*
    public static String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    */
}
