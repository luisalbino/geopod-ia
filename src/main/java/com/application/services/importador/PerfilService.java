package com.application.services.importador;

import com.application.entities.importador.PerfilEntity;
import com.application.enums.importador.ModuloEnum;
import com.application.models.importador.PerfilModel;
import com.application.models.importador.SQLModel;
import com.application.repositories.importador.PerfilRepository;
import com.application.services.AbstractService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PerfilService extends AbstractService<PerfilEntity, PerfilRepository> {

    protected PerfilService(PerfilRepository repository) {
        super(repository);
    }

    public List<PerfilModel> getModels() {
        var resultado = new ArrayList<PerfilModel>();

        var perfis = this.getAll();
        for (var perfil : perfis) {
            if (CollectionUtils.isNotEmpty(perfil.getSqls())) {
                var perfilModel = PerfilModel.builder()
                        .id(perfil.getId())
                        .descricao(perfil.getDescricao())
                        .sqls(new ArrayList<>())
                        .build();

                for (var sql : perfil.getSqls()) {
                    perfilModel.getSqls().add(SQLModel
                            .builder()
                            .codigoSql(sql.getCodigoSql())
                            .codigoModulo(sql.getCodigoModulo())
                            .sql(sql.getSql())
                            .isPadrao(sql.getIsPadrao())
                            .descricao(getSQLDescricao(sql.getCodigoModulo(), sql.getCodigoSql()))
                            .build());

                }

                resultado.add(perfilModel);
            }
        }

        return resultado;
    }

    private String getSQLDescricao(Integer codigoModulo, Integer codigoSQL) {
        String resultado = null;

        var mapNomes = ModuloEnum.getMapNomeSQL();

        if (mapNomes.containsKey(codigoModulo)) {
            resultado = mapNomes.get(codigoModulo).get(codigoSQL);
        }

        return resultado;
    }
}
