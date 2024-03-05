package com.application.services.importador;

import com.application.entities.importador.RamoEntity;
import com.application.repositories.importador.RamoRepository;
import com.application.services.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class RamoService extends AbstractService<RamoEntity, RamoRepository> {

    protected RamoService(RamoRepository repository) {
        super(repository);
    }
}
