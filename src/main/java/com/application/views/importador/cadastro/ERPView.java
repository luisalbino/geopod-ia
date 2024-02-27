package com.application.views.importador.cadastro;

import com.application.components.importador.erp.CadastroERPComponent;
import com.application.components.importador.erp.ConsultaERPComponent;
import com.application.entities.importador.ERPEntity;
import com.application.services.importador.ERPService;
import com.application.views.MainLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@PermitAll
@PageTitle("Importador SQL - Cadastro ERPs")
@Route(value = "cadastro-erp", layout = MainLayout.class)
public class ERPView extends SplitLayout {

    private final CadastroERPComponent cadastro;

    public ERPView(ERPService service) {
        super();

        var consulta = new ConsultaERPComponent(service, this::onEditarItem);
        cadastro = new CadastroERPComponent(service, consulta::atualizarDados);

        setSizeFull();
        addToPrimary(consulta);
        addToSecondary(cadastro);
    }

    private void onEditarItem(ERPEntity erp) {
        cadastro.open(erp);
    }
}
