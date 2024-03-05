package com.application.components.importador.sql;

import com.application.components.importador.AbstractCadastro;
import com.application.entities.importador.GeoScriptEntity;
import com.application.services.importador.SqlService;

public class CadastroSqlComponent extends AbstractCadastro<SqlService, GeoScriptEntity> {

    public CadastroSqlComponent(SqlService service, Runnable afterSave) {
        super(service, GeoScriptEntity::new, afterSave);

        configFormulario();
    }

    private void configFormulario() {
        formularioExtra.setPadding(false);


    }

    @Override
    protected void bloquearFormularioExtra() {
        //campoBancoDeDados.setReadOnly(true);
        //campoERP.setReadOnly(true);
        //campoRamo.setReadOnly(true);
    }

    @Override
    protected void liberarFormularioExtra() {
        //campoBancoDeDados.setReadOnly(false);
        //campoERP.setReadOnly(false);
        //campoRamo.setReadOnly(false);
    }
}
