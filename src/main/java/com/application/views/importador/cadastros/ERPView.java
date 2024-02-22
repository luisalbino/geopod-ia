package com.application.views.importador.cadastros;

import com.application.components.importador.cadastros.CadastroERPComponent;
import com.application.components.importador.consultas.ConsultaERPComponent;
import com.application.services.importador.ERPService;
import com.application.views.MainLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@PermitAll
@PageTitle("Importador SQL - Cadastro ERP")
@Route(value = "importador-cadastro-erp", layout = MainLayout.class)
public class ERPView extends SplitLayout {

    public ERPView(ERPService service) {
        super();

        var consulta = new ConsultaERPComponent(service);
        var cadastro = new CadastroERPComponent(service, consulta::atualizarDados);

        setSizeFull();
        addToPrimary(consulta);
        addToSecondary(cadastro);
    }
}
