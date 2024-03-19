package com.application.models.importador;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SQLModel implements Serializable {

    private Integer codigoSql;
    private Integer codigoModulo;


    private String sql;
    private Boolean isPadrao;
}
