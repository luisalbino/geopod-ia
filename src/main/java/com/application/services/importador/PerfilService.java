package com.application.services.importador;

import com.application.entities.importador.PerfilEntity;
import com.application.repositories.importador.PerfilRepository;
import com.application.services.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class PerfilService extends AbstractService<PerfilEntity, PerfilRepository> {

    protected PerfilService(PerfilRepository repository) {
        super(repository);
    }
}
