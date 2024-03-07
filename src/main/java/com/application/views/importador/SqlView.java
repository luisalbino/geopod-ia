package com.application.views.importador;

import com.application.components.importador.geoScript.GeoScriptEditorComponent;
import com.application.entities.importador.PerfilEntity;
import com.application.enums.GeoAnalyticsScriptEnum;
import com.application.enums.GeoB2bScriptEnum;
import com.application.enums.GeoCrmScriptEnum;
import com.application.enums.GeoForcaVendasScriptEnum;
import com.application.services.importador.PerfilService;
import com.application.services.importador.GeoScriptService;
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

    private Collection<PerfilEntity> listaPerfis;
    private final GeoScriptService geoScriptService;
    private TabSheet tabSheet;
    private ComboBox<PerfilEntity> comboBoxPerfis;

    public SqlView(PerfilService perfilService, GeoScriptService geoScriptService) {
        super();
        this.geoScriptService = geoScriptService;
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
        VerticalLayout tabSheetLayout = new VerticalLayout();
        tabSheetLayout.setSizeFull();
        bodyLayout.add(comboBoxPerfis, tabSheetLayout);
        return bodyLayout;
    }

    private void loadTabSheet(PerfilEntity perfil) {
        clearTabSheet();
        tabSheet = new TabSheet();
        tabSheet.add("Analytics", new GeoScriptEditorComponent<>(GeoAnalyticsScriptEnum.class, geoScriptService, perfil));
        tabSheet.add("Força de Vendas", new GeoScriptEditorComponent<>(GeoForcaVendasScriptEnum.class, geoScriptService, perfil));
        tabSheet.add("B2B", new GeoScriptEditorComponent<>(GeoB2bScriptEnum.class, geoScriptService, perfil));
        tabSheet.add("CRM", new GeoScriptEditorComponent<>(GeoCrmScriptEnum.class, geoScriptService, perfil));
        tabSheet.setSizeFull();
        VerticalLayout tabSheetLayout = (VerticalLayout) getPrimaryComponent().getChildren().toArray()[1];
        tabSheetLayout.add(tabSheet);
    }

    private void clearTabSheet() {
        if (tabSheet != null) {
            VerticalLayout tabSheetLayout = (VerticalLayout) getPrimaryComponent().getChildren().toArray()[1];
            tabSheetLayout.remove(tabSheet);
            tabSheet = null;
        }
    }
}
