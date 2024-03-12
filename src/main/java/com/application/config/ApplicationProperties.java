package com.application.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(ApplicationProperties.class)
@ConfigurationProperties(prefix = "geo")
@Configuration
@Getter
@Setter
public class ApplicationProperties {

    private String usuarioLogin;

    private String usuarioSenha;

    private String autenticacaoSecret;

}