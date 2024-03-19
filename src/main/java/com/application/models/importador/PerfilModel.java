package com.application.models.importador;

import lombok.*;

import java.io.Serializable;
import java.util.Collection;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PerfilModel implements Serializable {

    private Long id;

    private String descricao;

    private Collection<SQLModel> sqls;
}
