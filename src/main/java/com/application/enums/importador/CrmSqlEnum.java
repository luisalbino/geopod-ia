package com.application.enums.importador;

public enum CrmSqlEnum {
    CRM_DADOS_CADASTRAIS(10, "Dados Cadastrais"),
    CRM_PESQUISA_POR_NOME(20, "Pesquisa por Nome"),
    CRM_PESQUISA_AVANCADA(21, "Pesquisa Avançada"),
    CRM_PESQUISA_POR_CELULAR(22, "Pesquisa por Celular"),
    CRM_LISTA_DE_PEDIDOS_CLIENTE(30, "Lista de Pedidos Cliente"),
    CRM_PEDIDO_DETALHADO(31, "Pedido - Detalhado"),
    CRM_PEDIDO_ITENS(35, "Pedido - Itens"),
    CRM_PEDIDO_NFS(37, "Pedido - NFs"),
    CRM_INFORMACOES_FINANCEIRAS(40, "Informações Financeiras"),
    CRM_INFORMACOES_FINANCEIRAS_POR_SITUACAO(45, "Informações Financeiras por Situação"),
    CRM_INFORMACOES_FINANCEIRAS_OCORRENCIAS(46, "Informações Financeiras - Ocorrências"),
    CRM_CLIENTES_DO_GRUPO(47, "Clientes do Grupo"),
    CRM_CONSULTA_DA_CLASSIFICACAO_DO_CLIENTE(48, "Consulta da Classificação do Cliente"),
    CRM_LISTA_DE_PEDIDOS_REPRESENTANTE(50, "Lista de Pedidos Representante"),
    CRM_LISTA_DE_CLIENTES_DO_ITINERARIO(60, "Lista de Clientes do Itinerário"),
    CRM_RESUMO_FINANCEIRO_DO_CLIENTE(70, "Resumo Financeiro do Cliente"),
    CRM_LISTA_DE_CONTATOS_DO_ERP(80, "Lista de Contatos do ERP"),
    CRM_LISTA_DE_TITULOS_DO_CLIENTE(90, "Lista de Títulos do Cliente"),
    CRM_PESQUISA_CLASSIFICACAO_1(101, "Pesquisa - Classificação 1"),
    CRM_VENDAS_POR_COLECAO(110, "Vendas por Coleção");

    private final int codigo;
    private final String descricao;

    CrmSqlEnum(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}