package com.application.entities.importador;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "bancos_de_dados")
public class BancoDadosEntity extends AbstractImportadorEntity {
}
