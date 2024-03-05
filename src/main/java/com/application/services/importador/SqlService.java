package com.application.services.importador;

import com.application.entities.importador.GeoScriptEntity;
import com.application.repositories.importador.GeoScriptRepository;
import com.application.services.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class SqlService extends AbstractService<GeoScriptEntity, GeoScriptRepository>  {

    protected SqlService(GeoScriptRepository repository) {
        super(repository);
    }
}
