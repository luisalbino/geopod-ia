package com.application.helpers;

import com.application.config.ApplicationProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Date;

public class JwtHelper {

    private final static Long UMA_HORA_EM_MILLIS = 3600000L;
    private final HttpServletRequest request;

    private String username = "";
    private String secret = "";

    public JwtHelper(ApplicationProperties applicationProperties, HttpServletRequest request) {
        this.request = request;

        username = applicationProperties.getUsuarioLogin();
        secret = applicationProperties.getAutenticacaoSecret();
    }

    public String generateToken() throws Exception {

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        String token = Jwts.builder()
                .setSubject(this.username)
                .claim("nome", this.username)
                .setIssuedAt(now)
                .setExpiration(new Date(nowMillis + UMA_HORA_EM_MILLIS)) // expira em 1 hora
                .signWith(SignatureAlgorithm.HS256, this.secret)
                .compact();

        HttpSession session = this.request.getSession();
        session.setAttribute("geoToken", token);

        return token;
    }

    public boolean tokenIsValid(String token) throws Exception {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        Date dataExpiracao = claims.getExpiration();
        return !dataExpiracao.before(new Date());
    }
}
