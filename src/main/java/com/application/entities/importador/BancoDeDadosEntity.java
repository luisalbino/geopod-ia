package com.application.entities.importador;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@Entity(name = "bancos_de_dados")
public class BancoDeDadosEntity extends AbstractImportadorEntity {

    @OneToMany(mappedBy = "bancoDeDados")
    private Collection<PerfilEntity> perfis;

}
