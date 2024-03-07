package com.application.services.importador;

import com.application.entities.importador.GeoScriptEntity;
import com.application.entities.importador.PerfilEntity;
import com.application.repositories.importador.GeoScriptRepository;
import com.application.services.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeoScriptService extends AbstractService<GeoScriptEntity, GeoScriptRepository>  {

    protected GeoScriptService(GeoScriptRepository repository) {
        super(repository);
    }

    public GeoScriptEntity findByPerfilAndScriptModuleNameAndScriptCode(PerfilEntity perfil, String scriptModuleName, int scriptCode) {
        return repository.findByPerfilAndScriptModuleNameAndScriptCode(perfil, scriptModuleName, scriptCode);
    }

    public List<GeoScriptEntity> findByPerfil(PerfilEntity perfil) {
        return repository.findByPerfil(perfil);
    }
}
