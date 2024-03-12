package com.application.services.importador;

import com.application.entities.importador.SqlEntity;
import com.application.entities.importador.PerfilEntity;
import com.application.enums.importador.ModuloEnum;
import com.application.repositories.importador.SqlRepository;
import com.application.services.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SqlService extends AbstractService<SqlEntity, SqlRepository>  {

    protected SqlService(SqlRepository repository) {
        super(repository);
    }

    public SqlEntity findByPerfilAndCodigoModuloAndCodigoSql(PerfilEntity perfil, Integer codigoModule, Integer scriptCode) {
        return repository.findByPerfilAndCodigoModuloAndCodigoSql(perfil, codigoModule, scriptCode);
    }

    public List<SqlEntity> findByPerfil(PerfilEntity perfil) {
        return repository.findByPerfil(perfil);
    }
}
