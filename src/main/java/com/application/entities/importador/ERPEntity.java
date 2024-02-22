package com.application.entities.importador;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "erp")
public class ERPEntity extends ImportadorEntity {

    @Column(columnDefinition = "text")
    private String descricao;

}
