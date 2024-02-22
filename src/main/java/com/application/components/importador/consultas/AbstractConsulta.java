package com.application.components.importador.consultas;

import com.application.entities.importador.ImportadorEntity;
import com.application.services.AbstractService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.Collection;

public abstract class AbstractConsulta<S extends AbstractService<E, ?>, E extends ImportadorEntity> extends VerticalLayout {

    private final S service;
    private Collection<E> dados;
    private final Grid<E> grid = new Grid<>();
    private final ComboBox<E> campoFiltroDescricao = new ComboBox<>("Filtro");

    protected AbstractConsulta(S service) {
        this.service = service;
        this.dados = this.service.getAll();

        configFiltros();
        configTabelaDados();
    }

    private void configFiltros() {
        campoFiltroDescricao.setItems(this.dados);
        add(campoFiltroDescricao);
    }

    private void configTabelaDados() {
        grid.addColumn(E::getId).setHeader("Id");
        grid.addColumn(E::getDescricao).setHeader("Descrição");
        grid.setItems(this.dados);
        add(grid);
    }

    public void atualizarDados() {
        this.dados = this.service.getAll();

        this.grid.setItems(this.dados);
        this.campoFiltroDescricao.setItems(this.dados);
    }
}
