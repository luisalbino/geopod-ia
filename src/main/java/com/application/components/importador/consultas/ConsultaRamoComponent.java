package com.application.components.importador.consultas;

import com.application.entities.importador.RamoEntity;
import com.application.helpers.interfaces.RunnableWithParameter;
import com.application.services.importador.RamoService;

public class ConsultaRamoComponent extends AbstractConsulta<RamoService, RamoEntity> {

    public ConsultaRamoComponent(RamoService service, RunnableWithParameter<RamoEntity> onEditarItem) {
        super(service, onEditarItem);
    }
}
