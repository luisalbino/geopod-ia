package com.application.views.importador;

import com.application.components.importador.sql.SqlEditorComponent;
import com.application.entities.importador.PerfilEntity;
import com.application.enums.importador.*;
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

    private final transient SqlService sqlService;
    private final Collection<PerfilEntity> listaPerfis;

    private ComboBox<PerfilEntity> comboBoxPerfis;
    private VerticalLayout tabSheetLayout;

    public SqlView(PerfilService perfilService, SqlService sqlService) {
        super();
        this.sqlService = sqlService;
        listaPerfis = perfilService.getAll();
        setSizeFull();

        initializeComponents();
        addToPrimary(getBody());
    }

    private void initializeComponents() {
        comboBoxPerfis = new ComboBox<>("Selecione um Perfil");
        comboBoxPerfis.setItems(listaPerfis);
        comboBoxPerfis.setItemLabelGenerator(PerfilEntity::getDescricao);

        comboBoxPerfis.addValueChangeListener(event -> {
            if (event.getValue() != null) {
                loadTabSheet(event.getValue());
            } else {
                clearTabSheet();
            }
        });
    }

    private Component getBody() {
        VerticalLayout bodyLayout = new VerticalLayout();
        bodyLayout.add(comboBoxPerfis, this.getTabSheet());
        return bodyLayout;
    }

    private Component getTabSheet() {
        this.tabSheetLayout = new VerticalLayout();
        this.tabSheetLayout.setSizeFull();

        return this.tabSheetLayout;
    }

    private void loadTabSheet(PerfilEntity perfil) {
        TabSheet tabSheet;
        clearTabSheet();

        tabSheet = new TabSheet();
        tabSheet.add("Analytics", new SqlEditorComponent<>(AnalyticsSqlEnum.class, sqlService, perfil));
        tabSheet.add("Força de Vendas", new SqlEditorComponent<>(ForcaVendasSqlEnum.class, sqlService, perfil));
        tabSheet.add("B2B", new SqlEditorComponent<>(B2bSqlEnum.class, sqlService, perfil));
        tabSheet.add("CRM", new SqlEditorComponent<>(CrmSqlEnum.class, sqlService, perfil));
        tabSheet.add("Força de Vendas - Malharia", new SqlEditorComponent<>(ForcaVendasMalhariaSqlEnum.class, sqlService, perfil));
        tabSheet.setSizeFull();

        this.tabSheetLayout.add(tabSheet);
    }

    private void clearTabSheet() {
        this.tabSheetLayout.removeAll();
    }
}
