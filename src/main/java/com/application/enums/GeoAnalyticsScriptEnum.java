package com.application.enums;

public enum GeoAnalyticsScriptEnum {
    REPRESENTANTE(10, "Representante"),
    REPRESENTANTES_DOS_CLIENTES(11, "Representantes dos Clientes"),
    GERENTE_DE_REPRESENTANTE(12, "Gerente de Representante"),
    MUNICIPIOS_DO_REPRESENTANTE(15, "Municípios do Representante"),
    MUNICIPIOS_DO_ERP(16, "Municípios do ERP"),
    CLIENTES_E_PROSPECTS_POR_MUNICIPIO(20, "Clientes e Prospects por Município"),
    CLIENTE_E_PROSPECT_HISTORICO(22, "Cliente e Prospect - Histórico"),
    CLIENTES_INADIMPLENTES(25, "Clientes Inadimplentes"),
    MARCAS_DO_CLIENTE(28, "Marcas do Cliente"),
    COLECAO(30, "Coleção"),
    LINHA_DE_PRODUTO(40, "Linha de Produto"),
    MARCA(50, "Marca"),
    CONDICAO_DE_VENDA(60, "Condição de Venda"),
    META_DO_REPRESENTANTE(70, "Meta do Representante"),
    META_DO_CLIENTE(71, "Meta do Cliente"),
    META_DO_CLIENTE_POR_LINHA(74, "Meta do Cliente por Linha"),
    META_DO_REPRESENTANTE_POR_LINHA(75, "Meta do Representante por Linha"),
    META_POR_ESCRITORIO(76, "Meta por Escritório"),
    TRANSPORTADORA(80, "Transportadora"),
    CORINGA_1(910, "Coringa 1"),
    CORINGA_2(920, "Coringa 2"),
    CORINGA_3(930, "Coringa 3"),
    CORINGA_4(940, "Coringa 4"),
    CORINGA_5(950, "Coringa 5"),
    CORINGA_6(960, "Coringa 6"),
    VENDAS_1(1010, "Vendas1"),
    VENDAS_2(1011, "Vendas2"),
    VENDAS_DO_REPRESENTANTE_POR_REFERENCIA(1012, "Vendas do representante por referência"),
    FATURAMENTO_PARA_CONTRATO_DE_RESULTADOS(1015, "Faturamento para Contrato de Resultados"),
    LIQUIDEZ_D(1020, "Liquidez (D)"),
    NOTIFICADOR_DADOS_DA_DUPLICATA(1030, "Notificador - Dados da Duplicata"),
    NOTIFICADOR_DUPLICATAS_PARA_ENVIO_DE_EMAIL(1040, "Notificador - Duplicatas para Envio de E-mail"),
    NOTIFICADOR_CONSULTA_DE_DUPLICATAS(1041, "Notificador - Consulta de Duplicatas"),
    NOTIFICADOR_ENVIO_MANUAL(1042, "Notificador - Envio Manual"),
    NOTIFICADOR_TIPO_DE_TITULO(1050, "Notificador - Tipo de Título"),
    NOTIFICADOR_EMPRESA(1060, "Notificador - Empresa"),
    NOTIFICADOR_PORTADOR(1070, "Notificador - Portador"),
    INTEGRACAO_DE_CLIENTE_UNICO(1100, "Integração de Cliente Único"),
    VALORES_PARA_CALCULO_DESCONTO_FIDELIDADE_ACUMULATIVA(1200, "Valores para Cálculo Desconto Fidelidade Acumulativa"),
    RANKING_DE_REFERENCIAS(1300, "Ranking de Referências"),
    PAISES(1310, "Países");

    private final int value;
    private final String description;

    GeoAnalyticsScriptEnum(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}