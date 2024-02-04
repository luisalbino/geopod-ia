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

        createLoginForm();
    }

    private void createLoginForm() {
        LoginI18n configuration = LoginI18n.createDefault();

        LoginI18n.Header header = new LoginI18n.Header();
        header.setTitle("GEOPod.IA");
        header.setDescription("");
        configuration.setHeader(header);

        LoginI18n.Form form = new LoginI18n.Form();
        form.setTitle(null);
        form.setUsername("Usuário");
        form.setPassword("Senha");
        form.setSubmit("Entrar");
        configuration.setForm(form);

        LoginI18n.ErrorMessage error = new LoginI18n.ErrorMessage();
        error.setTitle("Usuário/Senha incorretos");
        error.setMessage("Valide se todos os dados estão corretos!");
        configuration.setErrorMessage(error);

        login = new LoginOverlay();
        login.setI18n(configuration);
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
