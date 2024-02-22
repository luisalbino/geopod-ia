package com.application.components.importador.cadastros;

import com.application.entities.importador.ImportadorEntity;
import com.application.helpers.DoubleToLongConverter;
import com.application.services.AbstractService;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import io.micrometer.common.util.StringUtils;

import java.util.Objects;
import java.util.function.Supplier;

public class AbstractCadastro<S extends AbstractService<E, ?>, E extends ImportadorEntity> extends VerticalLayout {

    private final S service;
    private final Runnable afterSave;
    private final Supplier<E> instanciaVazia;
    private final Binder<E> binder = new Binder<>();

    private final Button botaoNovo = new Button("Novo");
    private final Button botaoSalvar = new Button("Salvar");
    private final Button botaoCancelar = new Button("Cancelar");

    private final NumberField campoId;
    private final TextField campoDescricao = new TextField("Descrição");

    protected AbstractCadastro(S service, Supplier<E> instanciaVazia, Runnable afterSave) {
        this.service = service;
        this.afterSave = afterSave;
        this.instanciaVazia = instanciaVazia;
        this.binder.setBean(this.instanciaVazia.get());

        campoId = new NumberField();
        campoId.setWidth("75px");
        campoId.setReadOnly(true);
        this.binder.forField(campoId)
                .withConverter(new DoubleToLongConverter())
                .bind(E::getId, E::setId);

        campoDescricao.setWidth("350px");
        campoDescricao.setReadOnly(true);
        this.binder.forField(campoDescricao)
                .withValidator(StringUtils::isNotBlank, "Informe uma descrição antes de salvar!")
                .bind(E::getDescricao, E::setDescricao);

        add(campoId, campoDescricao, getFormulario());
    }

    private void onBotaoNovoClick(ClickEvent<Button> evento) {
        binder.refreshFields();
        botaoNovo.setEnabled(false);
        botaoSalvar.setEnabled(true);
        botaoCancelar.setEnabled(true);

        campoDescricao.setReadOnly(false);
        campoDescricao.focus();
    }

    private void onBotaoSalvarClick(ClickEvent<Button> evento) {
        binder.validate();
        if (binder.isValid()) {
            botaoNovo.setEnabled(true);
            botaoSalvar.setEnabled(false);
            botaoCancelar.setEnabled(false);

            service.save(binder.getBean());
            binder.setBean(this.instanciaVazia.get());
            runAfterSave();
        }
    }

    private void onBotaoCancelarClick(ClickEvent<Button> evento) {
        botaoNovo.setEnabled(true);
        botaoSalvar.setEnabled(false);
        botaoCancelar.setEnabled(false);
        this.binder.setBean(this.instanciaVazia.get());
    }

    private Component getFormulario() {
        botaoNovo.addClickListener(this::onBotaoNovoClick);
        botaoNovo.addThemeVariants(ButtonVariant.LUMO_SUCCESS);

        botaoSalvar.setEnabled(false);
        botaoSalvar.addClickListener(this::onBotaoSalvarClick);
        botaoSalvar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        botaoCancelar.setEnabled(false);
        botaoCancelar.addThemeVariants(ButtonVariant.LUMO_ERROR);
        botaoCancelar.addClickListener(this::onBotaoCancelarClick);

        return new HorizontalLayout(botaoNovo, botaoSalvar, botaoCancelar);
    }

    public void runAfterSave() {
        if (Objects.nonNull(afterSave)) {
            afterSave.run();
        }
    }
}
