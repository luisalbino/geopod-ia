package com.application.services.security;

import com.application.config.ApplicationProperties;
import com.application.views.user.LoginView;
import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Objects;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends VaadinWebSecurity {
    private final ApplicationProperties applicationProperties;

    public SecurityConfig(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize.requestMatchers("/api/**").permitAll())
            .csrf(csrf -> csrf.ignoringRequestMatchers("/api/**"));

        super.configure(http);
        setLoginView(http, LoginView.class);
    }

    @Bean
    public UserDetailsService users() {
        String login = Objects.nonNull(applicationProperties.getUsuarioLogin()) ? applicationProperties.getUsuarioLogin() : "";
        String senha = Objects.nonNull(applicationProperties.getUsuarioSenha()) ? applicationProperties.getUsuarioSenha() : "";

        var bCrypt = new BCryptPasswordEncoder();
        return new InMemoryUserDetailsManager(User.builder()
                .username(login)
                .password("{bcrypt}" + bCrypt.encode(senha))
                .roles("MASTER")
                .build());
    }
}

