package com.application.repositories.importador;

import com.application.entities.importador.GeoScriptEntity;
import com.application.entities.importador.PerfilEntity;
import com.application.repositories.AbstractRepository;

public interface GeoScriptRepository extends AbstractRepository<GeoScriptEntity> {

    GeoScriptEntity findByPerfilAndScriptModuleNameAndScriptCode(PerfilEntity perfil, String scriptModuleName, int scriptCode);

}
