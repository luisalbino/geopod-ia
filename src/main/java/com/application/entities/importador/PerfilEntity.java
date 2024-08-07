package com.application.entities.importador;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity(name = "perfis")
public class PerfilEntity extends AbstractImportadorEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "ramo_id", nullable = false)
    private RamoEntity ramo;

    @ManyToOne
    @JoinColumn(name = "erp_id", nullable = false)
    private ERPEntity erp;

    @ManyToOne
    @JoinColumn(name = "banco_de_dados_id", nullable = false)
    private BancoDeDadosEntity bancoDeDados;

    @OneToMany(mappedBy = "perfil")
    private Collection<SqlEntity> sqls;
}
