package com.application.repositories.importador;

import com.application.entities.importador.SqlEntity;
import com.application.entities.importador.PerfilEntity;
import com.application.enums.importador.ModuloEnum;
import com.application.repositories.AbstractRepository;

import java.util.List;

public interface SqlRepository extends AbstractRepository<SqlEntity> {

    SqlEntity findByPerfilAndCodigoModuloAndCodigoSql(PerfilEntity perfil, Integer codigoModulo, Integer codigoSql);

    List<SqlEntity> findByPerfil(PerfilEntity perfil);

}
