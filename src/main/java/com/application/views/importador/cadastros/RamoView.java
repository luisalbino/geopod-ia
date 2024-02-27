package com.application.views.importador.cadastros;

import com.application.views.MainLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@PermitAll
@PageTitle("Importador SQL - Cadastro ERP")
@Route(value = "cadastro-erp", layout = MainLayout.class)
public class RamoView extends SplitLayout {
}
