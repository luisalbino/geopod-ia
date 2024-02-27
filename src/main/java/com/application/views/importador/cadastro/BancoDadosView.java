package com.application.views.importador.cadastro;

import com.application.components.importador.cadastro.CadastroBancoDadosComponent;
import com.application.components.importador.consultas.ConsultaBancoDadosComponent;
import com.application.entities.importador.BancoDadosEntity;
import com.application.services.importador.BancoDadosService;
import com.application.views.MainLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@PermitAll
@PageTitle("Importador SQL - Cadastro Banco de Dados")
@Route(value = "cadastro-banco-dados", layout = MainLayout.class)
public class BancoDadosView extends SplitLayout {

    private final CadastroBancoDadosComponent cadastro;

    public BancoDadosView(BancoDadosService service) {
        super();

        var consulta = new ConsultaBancoDadosComponent(service, this::onEditarItem);
        cadastro = new CadastroBancoDadosComponent(service, consulta::atualizarDados);

        setSizeFull();
        addToPrimary(consulta);
        addToSecondary(cadastro);
    }

    private void onEditarItem(BancoDadosEntity bancoDados) {
        cadastro.open(bancoDados);
    }

}
