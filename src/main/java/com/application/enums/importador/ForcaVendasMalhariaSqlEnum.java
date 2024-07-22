package com.application.enums.importador;

public enum ForcaVendasMalhariaSqlEnum {
    FVM_PRODUTO(10, "Produto"),
    FVM_PRODUTO_VARIANTES(15, "Produto_Variantes"),
    FVM_TABELA_DE_PRECO(20, "Tabela de preço"),
    FVM_CATALOGOS(30, "Catalogos"),
    FVM_PRODUTO_VINCULO_ACESSORIOS(40, "Produto vinculo Acessórios"),
    FVM_TABELA_DE_PRECO_CAPA(50, "Tabela de preço_Capa"),
    FVM_CONDICOES_DE_VENDA(60, "Condições de Venda"),
    FVM_LOTE_DE_FATURAMENTO(70, "Lote de Faturamento"),
    FVM_LISTAGEM_DE_PEDIDOS_CAPA(80, "Listagem de pedidos_Capa"),
    FVM_LISTAGEM_DE_PEDIDOS_DETALHADO(90, "Listagem de pedidos_Detalhado"),
    FVM_LISTAGEM_DE_PEDIDOS_ITENS(100, "Listagem de pedidos_Itens"),
    FVM_LISTAGEM_DE_PEDIDOS_NOTAS(110, "Listagem de pedidos_Notas"),
    FVM_LISTAGEM_DE_PEDIDOS_NOTAS_ITENS(115, "Listagem de pedidos_Notas Itens"),
    FVM_PRODUTOS_EXCLUSIVOS(120, "Produtos Exclusivos"),
    FVM_LISTA_DE_PEDIDOS_SITUACAO_ERP(130, "Lista de pedidos_Situação ERP"),
    FVM_LISTA_DE_PEDIDOS_TIPO_NOTA(140, "Lista de pedidos_Tipo Nota"),
    FVM_TRIANGULACAO(150, "Triangulação"),
    FVM_TRANSPORTADORA(160, "Transportadora"),
    FVM_COMISSOES_EXTRATO_RESUMO(170, "Comissões_Extrato Resumo"),
    FVM_COMISSOES_EXTRATO_DETALHADO(180, "Comissões_Extrato Detalhado"),
    FVM_TIPO_COBRANCA(190, "Tipo Cobrança"),
    FVM_CONDICAO_DE_PAGAMENTO(200, "Condição de Pagamento"),
    FVM_TABELA_DE_PRECO_CAPA_CLIENTES(210, "Tabela de preço capa_Clientes"),
    FVM_TABELA_DE_PRECO_CAPA_REPRESENTANTES(220, "Tabela de preço capa_Representantes"),
    FVM_TITULOS(230, "Títulos"),
    FVM_CAMPOS_CUSTOMIZADOS(240, "Campos Customizados"),
    FVM_PARTIDAS_DE_PEDIDOS(250, "Partidas de Pedidos"),
    FVM_LISTA_PUBLICA_DE_CLIENTES(260, "Lista pública de clientes"),
    FVM_LISTAGEM_DE_PEDIDOS_PARA_CONJUGAR(270, "Listagem de pedidos para conjugar"),
    FVM_CARGA_MAQUINA_URBANO(280, "Carga Máquina_Urbano"),
    FVM_POLITICA_COMERCIAL_DALILA_PROPORCIONAL_CONDICAO_DE_PAGAMENTO_ERP_PRECO_SUGERIDO(290, "Politica Comercial_Dalila_Proporcional Condição de Pagamento ERP_Preço Sugerido"),
    FVM_POLITICA_COMERCIAL_DALILA_PROPORCIONAL_CONDICAO_DE_PAGAMENTO_ERP_COMISSAO_SUGERIDA(300, "Politica Comercial_Dalila_Proporcional Condição de Pagamento ERP_Comissão Sugerida"),
    FVM_CARGA_MAQUINA_DALILA(310, "Carga Máquina_Dalila");

    private final int codigo;
    private final String descricao;

    ForcaVendasMalhariaSqlEnum(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getModulo() {return ModuloEnum.FORCA_DE_VENDAS_MALHARIA.getCodigo();}
}
