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
        try {
            response.setCharacterEncoding("UTF-8");

            String authorizationHeader = request.getHeader("Authorization");
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                HttpSession session = request.getSession();
                String sessionToken = (String) session.getAttribute("geoToken");
                String requestToken = authorizationHeader.substring(7);

                JwtHelper jwtHelper = new JwtHelper(this.applicationProperties, request);
                if (sessionToken != null && sessionToken.equals(requestToken) && jwtHelper.tokenIsValid(sessionToken)) {
                    return true;
                }
            }

            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Token de autenticação não fornecido ou inválido");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }
}