package com.application.components.importador.consultas;

import com.application.entities.importador.BancoDadosEntity;
import com.application.helpers.interfaces.RunnableWithParameter;
import com.application.services.importador.BancoDadosService;

public class ConsultaBancoDadosComponent  extends AbstractConsulta<BancoDadosService, BancoDadosEntity> {

    public ConsultaBancoDadosComponent(BancoDadosService service, RunnableWithParameter<BancoDadosEntity> onEditarItem) {
        super(service, onEditarItem);
    }
}
