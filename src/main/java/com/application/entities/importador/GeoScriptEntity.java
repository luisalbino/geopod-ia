package com.application.entities.importador;

import com.application.enums.GeoAnalyticsScriptEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "geo_script")
public class GeoScriptEntity extends AbstractImportadorEntity {

    @ManyToOne
    private PerfilEntity perfil;

    private String scriptModuleName;

    private int scriptCode;

    private String sql;

}
