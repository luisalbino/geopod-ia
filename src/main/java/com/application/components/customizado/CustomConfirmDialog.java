package com.application.components.customizado;

import com.application.helpers.interfaces.RunnableWithParameter;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Span;
import org.apache.commons.lang3.NotImplementedException;

import java.util.Objects;

public class CustomConfirmDialog<E> extends Dialog {

    private E entidade;
    private final RunnableWithParameter<E> onConfirm;

    public CustomConfirmDialog(String titulo, String descricao, RunnableWithParameter<E> onConfirm) {
        this.onConfirm = onConfirm;

        setCloseOnEsc(false);
        setCloseOnOutsideClick(false);

        setHeaderTitle(titulo);
        configDescricao(descricao);
        configFooter();
    }

    private void configDescricao(String descricao) {
        add(new Span(descricao));
    }

    private void configFooter() {
        var botaoConfirmar = new Button("Confirmar");
        botaoConfirmar.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        botaoConfirmar.addClickListener(click -> {
           if (Objects.nonNull(this.onConfirm)) {
               this.onConfirm.run(this.entidade);
               super.close();
           }
        });

        var botaoCancelar = new Button("Cancelar");
        botaoCancelar.addThemeVariants(ButtonVariant.LUMO_ERROR);
        botaoCancelar.addClickListener(click -> super.close());

        getFooter().add(botaoCancelar, botaoConfirmar);
    }

    @Override
    public void open() {
        // Use o open(E entidade)
        throw new NotImplementedException();
    }

    public void open(E entidade) {
        this.entidade = entidade;
        super.open();
    }
}
