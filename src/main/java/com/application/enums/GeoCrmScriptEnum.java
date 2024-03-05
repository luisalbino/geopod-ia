package com.application.enums;

public enum GeoCrmScriptEnum {
    DADOS_CADASTRAIS(10, "Dados Cadastrais"),
    PESQUISA_POR_NOME(20, "Pesquisa por Nome"),
    PESQUISA_AVANCADA(21, "Pesquisa Avançada"),
    PESQUISA_POR_CELULAR(22, "Pesquisa por Celular"),
    LISTA_DE_PEDIDOS_CLIENTE(30, "Lista de Pedidos Cliente"),
    PEDIDO_DETALHADO(31, "Pedido - Detalhado"),
    PEDIDO_ITENS(35, "Pedido - Itens"),
    PEDIDO_NFS(37, "Pedido - NFs"),
    INFORMACOES_FINANCEIRAS(40, "Informações Financeiras"),
    INFORMACOES_FINANCEIRAS_POR_SITUACAO(45, "Informações Financeiras por Situação"),
    INFORMACOES_FINANCEIRAS_OCORRENCIAS(46, "Informações Financeiras - Ocorrências"),
    CLIENTES_DO_GRUPO(47, "Clientes do Grupo"),
    CONSULTA_DA_CLASSIFICACAO_DO_CLIENTE(48, "Consulta da Classificação do Cliente"),
    LISTA_DE_PEDIDOS_REPRESENTANTE(50, "Lista de Pedidos Representante"),
    LISTA_DE_CLIENTES_DO_ITINERARIO(60, "Lista de Clientes do Itinerário"),
    RESUMO_FINANCEIRO_DO_CLIENTE(70, "Resumo Financeiro do Cliente"),
    LISTA_DE_CONTATOS_DO_ERP(80, "Lista de Contatos do ERP"),
    LISTA_DE_TITULOS_DO_CLIENTE(90, "Lista de Títulos do Cliente"),
    PESQUISA_CLASSIFICACAO_1(101, "Pesquisa - Classificação 1"),
    VENDAS_POR_COLECAO(110, "Vendas por Coleção");

    private final int value;
    private final String description;

    GeoCrmScriptEnum(int value, String description) {
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