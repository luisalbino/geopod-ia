package com.application.components.importador.sql;

import com.application.components.importador.AbstractConsulta;
import com.application.entities.importador.GeoScriptEntity;
import com.application.helpers.interfaces.RunnableWithParameter;
import com.application.services.importador.SqlService;

public class ConsultaSqlComponent extends AbstractConsulta<SqlService, GeoScriptEntity> {

    public ConsultaSqlComponent(SqlService service, RunnableWithParameter<GeoScriptEntity> onEditarItem) {
        super(service, onEditarItem);
    }
}
