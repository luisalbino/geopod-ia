package com.application.models.importador;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SQLModel implements Serializable {

    private String sql;
    private String descricao;

    private Integer codigoSql;
    private Integer codigoModulo;

    private Boolean isPadrao;
}
