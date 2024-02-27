package com.application.components.importador.cadastro;

import com.application.entities.importador.BancoDadosEntity;
import com.application.services.importador.BancoDadosService;

public class CadastroBancoDadosComponent extends AbstractCadastro<BancoDadosService, BancoDadosEntity> {

    public CadastroBancoDadosComponent(BancoDadosService service, Runnable afterSave) {
        super(service, BancoDadosEntity::new, afterSave);
    }
}
