package com.application.parser.importador;

import com.application.entities.importador.GeoScriptEntity;
import com.application.parser.AbstractParser;
import com.application.services.importador.GeoScriptService;

public class GeoScriptParser extends AbstractParser<GeoScriptEntity, GeoScriptService> {

    public GeoScriptParser(GeoScriptService geoScriptService) {
        super(geoScriptService);
    }

    @Override
    public void parse(GeoScriptEntity scriptEntity) {

    }

}
