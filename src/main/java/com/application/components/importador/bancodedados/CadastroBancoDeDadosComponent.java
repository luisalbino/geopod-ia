package com.application.components.importador.bancodedados;

import com.application.components.importador.AbstractCadastro;
import com.application.entities.importador.BancoDeDadosEntity;
import com.application.services.importador.BancoDeDadosService;

public class CadastroBancoDeDadosComponent extends AbstractCadastro<BancoDeDadosService, BancoDeDadosEntity> {

    public CadastroBancoDeDadosComponent(BancoDeDadosService service, Runnable afterSave) {
        super(service, BancoDeDadosEntity::new, afterSave);
    }
}
