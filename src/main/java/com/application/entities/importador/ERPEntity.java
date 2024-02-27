package com.application.entities.importador;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@Entity(name = "erps")
public class ERPEntity extends AbstractImportadorEntity {

    @OneToMany(mappedBy = "erp")
    private Collection<PerfilEntity> perfis;
}
