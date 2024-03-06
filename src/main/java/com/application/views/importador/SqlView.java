package com.application.views.importador;

import com.application.components.importador.sql.SqlEditorComponent;
import com.application.entities.importador.PerfilEntity;
import com.application.enums.GeoAnalyticsScriptEnum;
import com.application.enums.GeoB2bScriptEnum;
import com.application.enums.GeoCrmScriptEnum;
import com.application.enums.GeoForcaVendasScriptEnum;
import com.application.services.importador.PerfilService;
import com.application.services.importador.SqlService;
import com.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

import java.util.Collection;

@PermitAll
@PageTitle("Importador SQL - Cadastro de SQL´s")
@Route(value = "cadastro-sql", layout = MainLayout.class)
public class SqlView extends SplitLayout {

    Collection<PerfilEntity> listaPerfis;
    private final SqlService sqlService;

    public SqlView(PerfilService perfilService, SqlService sqlService) {
        super();
        this.sqlService = sqlService;
        listaPerfis = perfilService.getAll();
        setSizeFull();

        addToPrimary(getBody());

    }

    private Component getBody(){
        VerticalLayout verticalLayout = new VerticalLayout();
        ComboBox<PerfilEntity> comboBoxPerfis = new ComboBox<>("Selecione um Perfil");
        comboBoxPerfis.setItems(listaPerfis);
        comboBoxPerfis.setItemLabelGenerator(PerfilEntity::getDescricao);

        TabSheet tabSheet = new TabSheet();
        tabSheet.add("Analytics",
                new SqlEditorComponent(GeoAnalyticsScriptEnum.class, sqlService));
        tabSheet.add("Força de Vendas",
                new SqlEditorComponent(GeoForcaVendasScriptEnum.class, sqlService));
        tabSheet.add("B2B",
                new SqlEditorComponent(GeoB2bScriptEnum.class, sqlService));
        tabSheet.add("CRM",
                new SqlEditorComponent(GeoCrmScriptEnum.class, sqlService));
        tabSheet.setSizeFull();
        verticalLayout.add(comboBoxPerfis);
        verticalLayout.add(tabSheet);
        return verticalLayout;
    }

}