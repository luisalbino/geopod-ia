package com.application.views.importador;

import com.application.components.importador.ramo.CadastroRamoComponent;
import com.application.components.importador.ramo.ConsultaRamoComponent;
import com.application.entities.importador.RamoEntity;
import com.application.services.importador.RamoService;
import com.application.views.MainLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@PermitAll
@PageTitle("Importador SQL - Cadastro Ramos")
@Route(value = "cadastro-ramo", layout = MainLayout.class)
public class RamoView extends SplitLayout {
    private final CadastroRamoComponent cadastro;

    public RamoView(RamoService service) {
        super();

        var consulta = new ConsultaRamoComponent(service, this::onEditarItem);
        cadastro = new CadastroRamoComponent(service, consulta::atualizarDados);

        setSizeFull();
        addToPrimary(consulta);
        addToSecondary(cadastro);
    }

    private void onEditarItem(RamoEntity ramo) {
        cadastro.open(ramo);
    }
}
