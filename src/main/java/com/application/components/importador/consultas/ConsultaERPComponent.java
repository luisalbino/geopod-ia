package com.application.components.importador.consultas;

import com.application.entities.importador.ERPEntity;
import com.application.services.importador.ERPService;

public class ConsultaERPComponent extends AbstractConsulta<ERPService, ERPEntity> {

    public ConsultaERPComponent(ERPService service) {
        super(service);

    }
}
