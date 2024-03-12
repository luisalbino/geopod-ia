package com.application.config;

import com.application.helpers.JwtHelper;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class JwtTokenInterceptor implements HandlerInterceptor {

    private final ApplicationProperties applicationProperties;

    public JwtTokenInterceptor(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("UTF-8");

        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            HttpSession session = request.getSession();
            String sessionToken = (String) session.getAttribute("geoToken");
            String requestToken = authorizationHeader.substring(7);

            //TODO corrigir decode para verificar a data de expiração do token
            //JwtHelper jwtHelper = new JwtHelper(this.applicationProperties, request);
            //boolean tokenIsValid = Boolean.TRUE.equals(jwtHelper.tokenIsValid(requestToken));

            if (sessionToken != null && sessionToken.equals(requestToken)) {
                return true;
            }
        }

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("Token de autenticação não fornecido ou inválido");
        return false;
    }
}