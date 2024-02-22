package com.application.services.importador;

import com.application.entities.importador.ERPEntity;
import com.application.repositories.importador.ERPRepository;
import com.application.services.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class ERPService extends AbstractService<ERPEntity, ERPRepository> {

    protected ERPService(ERPRepository repository) {
        super(repository);
    }

}
