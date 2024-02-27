package com.application.components.importador.consultas;

import com.application.entities.importador.AbstractImportadorEntity;
import com.application.helpers.interfaces.RunnableWithParameter;
import com.application.services.AbstractService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.Collection;

public abstract class AbstractConsulta<S extends AbstractService<E, ?>, E extends AbstractImportadorEntity> extends VerticalLayout {

    private final S service;
    private Collection<E> dados;
    private final Grid<E> grid = new Grid<>();
    private final ComboBox<E> campoFiltroDescricao = new ComboBox<>("Filtro");

    private final RunnableWithParameter<E> onEditarItem;

    protected AbstractConsulta(S service, RunnableWithParameter<E> onEditarItem) {
        this.service = service;
        this.onEditarItem = onEditarItem;
        this.dados = this.service.getAll();

        configFiltros();
        configTabelaDados();
    }

    private void configFiltros() {
        campoFiltroDescricao.setWidthFull();
        campoFiltroDescricao.setItems(this.dados);
        campoFiltroDescricao.setPlaceholder("Descrição...");
        campoFiltroDescricao.setItemLabelGenerator(E::getDescricao);

        add(campoFiltroDescricao);
    }

    private void configTabelaDados() {
        grid.addComponentColumn(this::getColunaAcao).setHeader("Ação").setAutoWidth(true).setFlexGrow(0);
        grid.addColumn(E::getId).setHeader("Id");
        grid.addColumn(E::getDescricao).setHeader("Descrição");
        grid.setItems(this.dados);
        add(grid);
    }

    private Component getColunaAcao(E entidade) {
        var botaoEditar = new Button(VaadinIcon.PENCIL.create());
        botaoEditar.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        botaoEditar.addClickListener(click -> this.onEditarItem.run(entidade));

        var botaoExcluir = new Button(VaadinIcon.TRASH.create());
        botaoExcluir.addThemeVariants(ButtonVariant.LUMO_ERROR);
        botaoExcluir.addClickListener(click -> {
           service.remove(entidade);
           atualizarDados();
        });

        return new HorizontalLayout(botaoEditar, botaoExcluir);
    }

    public void atualizarDados() {
        this.dados = this.service.getAll();

        this.grid.setItems(this.dados);
        this.campoFiltroDescricao.setItems(this.dados);
    }
}
