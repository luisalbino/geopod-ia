package com.application.views.user;

import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("login")
@AnonymousAllowed
@PageTitle("Login")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

    private LoginOverlay login;

    public LoginView() {
        setSizeFull();
        addClassName("login-view");
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        createLoginFormulario();
    }

    private void createLoginFormulario() {
        LoginI18n configuracao = LoginI18n.createDefault();

        LoginI18n.Header cabecalho = new LoginI18n.Header();
        cabecalho.setTitle("GEOPod.IA");
        cabecalho.setDescription("");
        configuracao.setHeader(cabecalho);

        LoginI18n.Form formulario = new LoginI18n.Form();
        formulario.setTitle(null);
        formulario.setUsername("Usuário");
        formulario.setPassword("Senha");
        formulario.setSubmit("Entrar");
        configuracao.setForm(formulario);

        LoginI18n.ErrorMessage error = new LoginI18n.ErrorMessage();
        error.setTitle("Usuário/Senha incorretos");
        error.setMessage("Valide se todos os dados estão corretos!");
        configuracao.setErrorMessage(error);

        login = new LoginOverlay();
        login.setI18n(configuracao);
        login.setForgotPasswordButtonVisible(false);
        login.setAction("login");
        login.setOpened(true);

        add(login);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if(beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            login.setError(true);
        }
    }
}
