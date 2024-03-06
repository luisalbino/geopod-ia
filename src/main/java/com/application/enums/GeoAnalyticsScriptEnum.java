package com.application.enums;

public enum GeoAnalyticsScriptEnum {
    AN_REPRESENTANTE(10, "Representante"),
    AN_REPRESENTANTES_DOS_CLIENTES(11, "Representantes dos Clientes"),
    AN_GERENTE_DE_REPRESENTANTE(12, "Gerente de Representante"),
    AN_MUNICIPIOS_DO_REPRESENTANTE(15, "Municípios do Representante"),
    AN_MUNICIPIOS_DO_ERP(16, "Municípios do ERP"),
    AN_CLIENTES_E_PROSPECTS_POR_MUNICIPIO(20, "Clientes e Prospects por Município"),
    AN_CLIENTE_E_PROSPECT_HISTORICO(22, "Cliente e Prospect - Histórico"),
    AN_CLIENTES_INADIMPLENTES(25, "Clientes Inadimplentes"),
    AN_MARCAS_DO_CLIENTE(28, "Marcas do Cliente"),
    AN_COLECAO(30, "Coleção"),
    AN_LINHA_DE_PRODUTO(40, "Linha de Produto"),
    AN_MARCA(50, "Marca"),
    AN_CONDICAO_DE_VENDA(60, "Condição de Venda"),
    AN_META_DO_REPRESENTANTE(70, "Meta do Representante"),
    AN_META_DO_CLIENTE(71, "Meta do Cliente"),
    AN_META_DO_CLIENTE_POR_LINHA(74, "Meta do Cliente por Linha"),
    AN_META_DO_REPRESENTANTE_POR_LINHA(75, "Meta do Representante por Linha"),
    AN_META_POR_ESCRITORIO(76, "Meta por Escritório"),
    AN_TRANSPORTADORA(80, "Transportadora"),
    AN_CORINGA_1(910, "Coringa 1"),
    AN_CORINGA_2(920, "Coringa 2"),
    AN_CORINGA_3(930, "Coringa 3"),
    AN_CORINGA_4(940, "Coringa 4"),
    AN_CORINGA_5(950, "Coringa 5"),
    AN_CORINGA_6(960, "Coringa 6"),
    AN_VENDAS_1(1010, "Vendas1"),
    AN_VENDAS_2(1011, "Vendas2"),
    AN_VENDAS_DO_REPRESENTANTE_POR_REFERENCIA(1012, "Vendas do representante por referência"),
    AN_FATURAMENTO_PARA_CONTRATO_DE_RESULTADOS(1015, "Faturamento para Contrato de Resultados"),
    AN_LIQUIDEZ_D(1020, "Liquidez (D)"),
    AN_NOTIFICADOR_DADOS_DA_DUPLICATA(1030, "Notificador - Dados da Duplicata"),
    AN_NOTIFICADOR_DUPLICATAS_PARA_ENVIO_DE_EMAIL(1040, "Notificador - Duplicatas para Envio de E-mail"),
    AN_NOTIFICADOR_CONSULTA_DE_DUPLICATAS(1041, "Notificador - Consulta de Duplicatas"),
    AN_NOTIFICADOR_ENVIO_MANUAL(1042, "Notificador - Envio Manual"),
    AN_NOTIFICADOR_TIPO_DE_TITULO(1050, "Notificador - Tipo de Título"),
    AN_NOTIFICADOR_EMPRESA(1060, "Notificador - Empresa"),
    AN_NOTIFICADOR_PORTADOR(1070, "Notificador - Portador"),
    AN_INTEGRACAO_DE_CLIENTE_UNICO(1100, "Integração de Cliente Único"),
    AN_VALORES_PARA_CALCULO_DESCONTO_FIDELIDADE_ACUMULATIVA(1200, "Valores para Cálculo Desconto Fidelidade Acumulativa"),
    AN_RANKING_DE_REFERENCIAS(1300, "Ranking de Referências"),
    AN_PAISES(1310, "Países");

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