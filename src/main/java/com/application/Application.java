package com.application;

import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 *
 */
@SpringBootApplication
@NpmPackage(value = "@fontsource/quicksand", version = "4.5.0")
@Theme(value = "geopod-ia")
public class Application implements AppShellConfigurator {

    public static String SECRET;

    public Application(Environment env) {
        SECRET = env.getProperty("autenticacao.secret");
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
