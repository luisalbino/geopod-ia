package com.application.components.importador.bancodedados;

import com.application.components.importador.AbstractConsulta;
import com.application.entities.importador.BancoDeDadosEntity;
import com.application.helpers.interfaces.RunnableWithParameter;
import com.application.services.importador.BancoDeDadosService;

public class ConsultaBancoDeDadosComponent extends AbstractConsulta<BancoDeDadosService, BancoDeDadosEntity> {

    public ConsultaBancoDeDadosComponent(BancoDeDadosService service, RunnableWithParameter<BancoDeDadosEntity> onEditarItem) {
        super(service, onEditarItem);
    }
}
