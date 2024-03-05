package com.application.components.importador.perfil;

import com.application.components.importador.AbstractConsulta;
import com.application.entities.importador.PerfilEntity;
import com.application.helpers.interfaces.RunnableWithParameter;
import com.application.services.importador.PerfilService;

public class ConsultaPerfilComponent extends AbstractConsulta<PerfilService, PerfilEntity> {

    public ConsultaPerfilComponent(PerfilService service, RunnableWithParameter<PerfilEntity> onEditarItem) {
        super(service, onEditarItem);
    }
}
