package com.application.views.importador.cadastros;

import com.application.components.importador.cadastros.CadastroERPComponent;
import com.application.components.importador.consultas.ConsultaERPComponent;
import com.application.entities.importador.ERPEntity;
import com.application.services.importador.ERPService;
import com.application.views.MainLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@PermitAll
@PageTitle("Importador SQL - Cadastro ERP")
@Route(value = "cadastro-erp", layout = MainLayout.class)
public class ERPView extends SplitLayout {

    private final ConsultaERPComponent consulta;
    private final CadastroERPComponent cadastro;

    public ERPView(ERPService service) {
        super();

        consulta = new ConsultaERPComponent(service, this::onEditarItem);
        cadastro = new CadastroERPComponent(service, consulta::atualizarDados);

        setSizeFull();
        addToPrimary(consulta);
        addToSecondary(cadastro);
    }

    private void onEditarItem(ERPEntity erp) {
        cadastro.open(erp);
    }
}
