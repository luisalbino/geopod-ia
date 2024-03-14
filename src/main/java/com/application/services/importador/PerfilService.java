package com.application.services.importador;

import com.application.entities.importador.PerfilEntity;
import com.application.models.importador.PerfilModel;
import com.application.repositories.importador.PerfilRepository;
import com.application.services.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
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
            resultado.add(PerfilModel.builder()
                    .id(perfil.getId())
                    .descricao(perfil.getDescricao())
                    .build());
        }

        return resultado;
    }

}
