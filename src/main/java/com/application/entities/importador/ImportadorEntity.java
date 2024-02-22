package com.application.entities.importador;

import com.application.entities.AbstractEntity;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class ImportadorEntity extends AbstractEntity {

    private String descricao;

}
