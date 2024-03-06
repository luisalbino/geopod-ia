package com.application.parser.importador;

import com.application.entities.importador.GeoScriptEntity;
import com.application.entities.importador.PerfilEntity;
import com.application.parser.AbstractParser;
import com.application.services.importador.SqlService;

public class GeoScriptParser extends AbstractParser<GeoScriptEntity, SqlService> {

    public GeoScriptParser(SqlService sqlService) {
        super(sqlService);
    }

    @Override
    public void parse(GeoScriptEntity scriptEntity) {

    }

}
