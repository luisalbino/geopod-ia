package com.application.components.importador.perfil;

import com.application.components.importador.AbstractCadastro;
import com.application.entities.importador.BancoDeDadosEntity;
import com.application.entities.importador.ERPEntity;
import com.application.entities.importador.PerfilEntity;
import com.application.entities.importador.RamoEntity;
import com.application.helpers.binder.validador.ObjectNotNullValidator;
import com.application.services.importador.PerfilService;
import com.application.services.importador.cadastro.CadastroPerfilService;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class CadastroPerfilComponent extends AbstractCadastro<PerfilService, PerfilEntity> {

    private final CadastroPerfilService cadastroPerfilService;
    private ComboBox<RamoEntity> campoRamo;
    private ComboBox<ERPEntity> campoERP;
    private ComboBox<BancoDeDadosEntity> campoBancoDeDados;

    public CadastroPerfilComponent(PerfilService service, CadastroPerfilService cadastroPerfilService, Runnable afterSave) {
        super(service, PerfilEntity::new, afterSave);
        this.cadastroPerfilService = cadastroPerfilService;

        configFormulario();
    }

    private void configFormulario() {
        formularioExtra.setPadding(false);

        campoRamo = new ComboBox<>("Ramo");
        campoRamo.setReadOnly(true);
        campoRamo.setRequired(true);
        campoRamo.setItems(cadastroPerfilService.getRamos());
        campoRamo.setItemLabelGenerator(RamoEntity::getDescricao);
        binder.forField(campoRamo)
                .withValidator(new ObjectNotNullValidator())
                .bind(PerfilEntity::getRamo, PerfilEntity::setRamo);

        campoERP = new ComboBox<>("ERP");
        campoERP.setReadOnly(true);
        campoERP.setRequired(true);
        campoERP.setItems(cadastroPerfilService.getERPs());
        campoERP.setItemLabelGenerator(ERPEntity::getDescricao);
        binder.forField(campoERP)
                .withValidator(new ObjectNotNullValidator())
                .bind(PerfilEntity::getErp, PerfilEntity::setErp);

        campoBancoDeDados = new ComboBox<>("Banco de dados");
        campoBancoDeDados.setReadOnly(true);
        campoBancoDeDados.setRequired(true);
        campoBancoDeDados.setItemLabelGenerator(BancoDeDadosEntity::getDescricao);
        campoBancoDeDados.setItems(cadastroPerfilService.getBancosDeDados());
        binder.forField(campoBancoDeDados)
                .withValidator(new ObjectNotNullValidator())
                .bind(PerfilEntity::getBancoDeDados, PerfilEntity::setBancoDeDados);

        this.formularioExtra.add(new HorizontalLayout(campoRamo, campoERP), campoBancoDeDados);
    }

    @Override
    protected void bloquearFormularioExtra() {
        campoBancoDeDados.setReadOnly(true);
        campoERP.setReadOnly(true);
        campoRamo.setReadOnly(true);
    }

    @Override
    protected void liberarFormularioExtra() {
        campoBancoDeDados.setReadOnly(false);
        campoERP.setReadOnly(false);
        campoRamo.setReadOnly(false);
    }
}
