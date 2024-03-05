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

    @Enumerated(EnumType.STRING)
    private GeoAnalyticsScriptEnum geoAnalyticsEnum;

    private String sql;

}
