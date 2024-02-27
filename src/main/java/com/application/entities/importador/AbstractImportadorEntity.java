package com.application.entities.importador;

import com.application.entities.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractImportadorEntity extends AbstractEntity {

    @Column(columnDefinition = "text")
    private String descricao;

}
