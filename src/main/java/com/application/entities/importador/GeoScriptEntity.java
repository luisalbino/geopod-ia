package com.application.entities.importador;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(uniqueConstraints={@UniqueConstraint(name ="geoscript_uk", columnNames = {"scriptCode", "scriptModuleName", "perfil_id"})})
@Entity(name = "geo_script")
public class GeoScriptEntity extends AbstractImportadorEntity {

    @ManyToOne(optional = false)
    private PerfilEntity perfil;

    private String scriptModuleName;

    private Integer scriptCode;

    private String sql;

    private Boolean isStandard = false;

}
