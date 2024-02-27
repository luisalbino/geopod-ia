package com.application.views.importador.cadastro;

import com.application.components.importador.bancodedados.CadastroBancoDeDadosComponent;
import com.application.components.importador.bancodedados.ConsultaBancoDeDadosComponent;
import com.application.entities.importador.BancoDeDadosEntity;
import com.application.services.importador.BancoDeDadosService;
import com.application.views.MainLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@PermitAll
@PageTitle("Importador SQL - Cadastro Banco de Dados")
@Route(value = "cadastro-banco-dados", layout = MainLayout.class)
public class BancoDeDadosView extends SplitLayout {

    private final CadastroBancoDeDadosComponent cadastro;

    public BancoDeDadosView(BancoDeDadosService service) {
        super();

        var consulta = new ConsultaBancoDeDadosComponent(service, this::onEditarItem);
        cadastro = new CadastroBancoDeDadosComponent(service, consulta::atualizarDados);

        setSizeFull();
        addToPrimary(consulta);
        addToSecondary(cadastro);
    }

    private void onEditarItem(BancoDeDadosEntity bancoDados) {
        cadastro.open(bancoDados);
    }

}
