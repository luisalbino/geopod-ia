package com.application.services.importador;

import com.application.entities.importador.BancoDadosEntity;
import com.application.repositories.importador.BancoDadosRepository;
import com.application.services.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class BancoDadosService extends AbstractService<BancoDadosEntity, BancoDadosRepository> {

    public BancoDadosService(BancoDadosRepository repository) {
        super(repository);
    }
}
