package com.application.components.importador.cadastros;

import com.application.entities.importador.ImportadorEntity;
import com.application.helpers.DoubleToLongConverter;
import com.application.services.AbstractService;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import io.micrometer.common.util.StringUtils;

public class AbstractCadastro<S extends AbstractService<E, ?>, E extends ImportadorEntity> extends VerticalLayout {

    private final S service;
    private final Binder<E> binder = new Binder<>();

    private final Button botaoNovo = new Button("Novo");
    private final Button botaoSalvar = new Button("Salvar");

    private final TextField campoDescricao = new TextField("Descrição");

    protected AbstractCadastro(S service, E instancia) {
        this.service = service;
        this.binder.setBean(instancia);

        var campoId = new NumberField();
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
        campoDescricao.setReadOnly(false);
    }

    private void onBotaoSalvarClick(ClickEvent<Button> evento) {
        botaoNovo.setEnabled(true);
        botaoSalvar.setEnabled(false);

        binder.validate();
        if (binder.isValid()) {
            service.save(binder.getBean());
            binder.getFields().forEach(HasValue::clear);
        }
    }

    private Component getFormulario() {
        botaoNovo.addClickListener(this::onBotaoNovoClick);
        botaoNovo.addThemeVariants(ButtonVariant.LUMO_SUCCESS);

        botaoSalvar.addClickListener(this::onBotaoSalvarClick);
        botaoSalvar.setEnabled(false);
        botaoSalvar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        return new HorizontalLayout(botaoNovo, botaoSalvar);
    }
}
