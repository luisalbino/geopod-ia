package com.application.services.importador;

import com.application.entities.importador.BancoDeDadosEntity;
import com.application.repositories.importador.BancoDeDadosRepository;
import com.application.services.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class BancoDeDadosService extends AbstractService<BancoDeDadosEntity, BancoDeDadosRepository> {

    public BancoDeDadosService(BancoDeDadosRepository repository) {
        super(repository);
    }
}
