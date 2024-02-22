package com.application.components.importador.consultas;

import com.application.entities.importador.ImportadorEntity;
import com.application.services.AbstractService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.Collection;

public abstract class AbstractConsulta<S extends AbstractService<E, ?>, E extends ImportadorEntity> extends VerticalLayout {

    private Collection<E> dados;

    protected AbstractConsulta(S service) {
        this.dados = service.getAll();

        add(getFiltros(), getTabelaDados());
    }

    private Component getFiltros() {
        var campoFiltroDescricao = new ComboBox<E>();
        campoFiltroDescricao.setItems(this.dados);

        return campoFiltroDescricao;
    }

    private Component getTabelaDados() {
        var grid = new Grid<E>();
        grid.addColumn(E::getId).setHeader("Id");
        grid.addColumn(E::getDescricao).setHeader("Descrição");
        grid.setItems(dados);

        return grid;
    }
}
