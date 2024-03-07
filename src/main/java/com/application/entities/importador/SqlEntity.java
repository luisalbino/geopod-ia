package com.application.entities.importador;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(uniqueConstraints={@UniqueConstraint(name ="sqls_uk", columnNames = {"codigoSql", "nomeModuloSql", "perfil_id"})})
@Entity(name = "sqls")
public class SqlEntity extends AbstractImportadorEntity {

    @ManyToOne(optional = false)
    private PerfilEntity perfil;

    private String nomeModuloSql;

    private Integer codigoSql;

    private String sql;

    private Boolean isPadrao = false;

}
