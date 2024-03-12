package com.application.enums.importador;

public enum ModuloEnum {
    ANALYTICS(10, "Analytics"),
    FORCA_DE_VENDAS(20, "Força de Vendas"),
    B2B(30, "B2B"),
    CRM(40, "CRM");

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
}
