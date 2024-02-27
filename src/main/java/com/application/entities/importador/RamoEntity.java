package com.application.entities.importador;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@Entity(name = "ramos")
public class RamoEntity extends AbstractImportadorEntity {

    @OneToMany(mappedBy = "ramo")
    private Collection<PerfilEntity> perfis;
}
