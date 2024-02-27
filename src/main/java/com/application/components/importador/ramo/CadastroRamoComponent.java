package com.application.components.importador.ramo;

import com.application.components.importador.AbstractCadastro;
import com.application.entities.importador.RamoEntity;
import com.application.services.importador.RamoService;

public class CadastroRamoComponent extends AbstractCadastro<RamoService, RamoEntity> {

    public CadastroRamoComponent(RamoService service, Runnable afterSave) {
        super(service, RamoEntity::new, afterSave);
    }
}
