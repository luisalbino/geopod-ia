package com.application.components.importador.consultas;

import com.application.entities.importador.ERPEntity;
import com.application.helpers.interfaces.RunnableWithParameter;
import com.application.services.importador.ERPService;

public class ConsultaERPComponent extends AbstractConsulta<ERPService, ERPEntity> {

    public ConsultaERPComponent(ERPService service, RunnableWithParameter<ERPEntity> onEditarItem) {
        super(service, onEditarItem);

    }
}
