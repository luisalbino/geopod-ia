package com.application.views.importador;

import com.application.components.importador.erp.CadastroERPComponent;
import com.application.components.importador.erp.ConsultaERPComponent;
import com.application.components.importador.perfil.CadastroPerfilComponent;
import com.application.components.importador.perfil.ConsultaPerfilComponent;
import com.application.entities.importador.ERPEntity;
import com.application.entities.importador.PerfilEntity;
import com.application.services.importador.ERPService;
import com.application.services.importador.PerfilService;
import com.application.services.importador.cadastro.CadastroPerfilService;
import com.application.views.MainLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@PermitAll
@PageTitle("Importador SQL - Cadastro perfis")
@Route(value = "", layout = MainLayout.class)
public class PerfilView extends SplitLayout {

    private final CadastroPerfilComponent cadastro;

    public PerfilView(PerfilService service, CadastroPerfilService cadastroPerfilService) {
        super();

        var consulta = new ConsultaPerfilComponent(service, this::onEditarItem);
        cadastro = new CadastroPerfilComponent(service, cadastroPerfilService, consulta::atualizarDados);

        setSizeFull();
        addToPrimary(consulta);
        addToSecondary(cadastro);
    }

    private void onEditarItem(PerfilEntity perfil) {
        cadastro.open(perfil);
    }
}
