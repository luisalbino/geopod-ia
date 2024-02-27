package com.application.views.importador.cadastro;

import com.application.views.MainLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@PermitAll
@PageTitle("Importador SQL - Cadastro perfil")
@Route(value = "", layout = MainLayout.class)
public class PerfilView extends VerticalLayout {

    public PerfilView() {
        add(new Span("Cadastro de perfil"));
    }
}
