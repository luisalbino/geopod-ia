package com.application.components.importador.cadastro;

import com.application.entities.importador.ERPEntity;
import com.application.services.importador.ERPService;

public class CadastroERPComponent extends AbstractCadastro<ERPService, ERPEntity> {

    public CadastroERPComponent(ERPService service, Runnable afterSave) {
        super(service, ERPEntity::new, afterSave);
    }
}
