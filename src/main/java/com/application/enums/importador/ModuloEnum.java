package com.application.enums.importador;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public enum ModuloEnum {
    ANALYTICS(10, "Analytics"),
    FORCA_DE_VENDAS(20, "Força de Vendas"),
    B2B(30, "B2B"),
    CRM(40, "CRM"),
    FORCA_DE_VENDAS_MALHARIA(50, "Força de Vendas - Malharia");

    private final int codigo;
    private final String descricao;

    ModuloEnum(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static ModuloEnum getByCodigo(int codigo) {
        for (ModuloEnum tipo : ModuloEnum.values()) {
            if (tipo.getCodigo() == codigo) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Código inválido: " + codigo);
    }

    public static Map<Integer, HashMap<Integer, String>> getMapNomeSQL() {
        var resultado = Arrays.stream(ModuloEnum.values()).collect(Collectors.toMap(ModuloEnum::getCodigo, value -> new HashMap<Integer, String>()));

        for (var sql : AnalyticsSqlEnum.values()) {
            resultado.get(ModuloEnum.ANALYTICS.codigo).put(sql.getCodigo(), sql.getDescricao());
        }

        for (var sql : ForcaVendasSqlEnum.values()) {
            resultado.get(ModuloEnum.FORCA_DE_VENDAS.codigo).put(sql.getCodigo(), sql.getDescricao());
        }

        for (var sql : B2bSqlEnum.values()) {
            resultado.get(ModuloEnum.B2B.codigo).put(sql.getCodigo(), sql.getDescricao());
        }

        for (var sql : CrmSqlEnum.values()) {
            resultado.get(ModuloEnum.CRM.codigo).put(sql.getCodigo(), sql.getDescricao());
        }

        for (var sql : ForcaVendasMalhariaSqlEnum.values()) {
            resultado.get(ModuloEnum.FORCA_DE_VENDAS_MALHARIA.codigo).put(sql.getCodigo(), sql.getDescricao());
        }

        return resultado;
    }
}
