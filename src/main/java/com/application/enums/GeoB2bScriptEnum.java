package com.application.enums;

public enum GeoB2bScriptEnum {
    REFERENCIA(10, "Referência"),
    REFERENCIA_GRADE(20, "Referência - Grade"),
    REFERENCIA_GRADE_FECHADA(21, "Referência - Grade Fechada"),
    REFERENCIA_SORTIMENTO(30, "Referência - Sortimento"),
    REFERENCIA_PRECOS(40, "Referência - Preços"),
    REFERENCIA_PRECOS_SKU(45, "Referência - Preços - SKU"),
    REFERENCIA_ESTOQUE(50, "Referência - Estoque"),
    REFERENCIA_ESTOQUE_PARCIAL(55, "Referência - Estoque Parcial"),
    REFERENCIA_POCKET(56, "Referência - Pocket"),
    PEDIDO_CAPA(60, "Pedido - Capa"),
    PEDIDO_HISTORICO(61, "Pedido - Histórico"),
    PEDIDO_DETALHE(62, "Pedido - Detalhe"),
    PEDIDO_ITENS(63, "Pedido - Itens"),
    PEDIDO_RECOMPRA(64, "Pedido - Recompra"),
    PEDIDO_ITENS_DETALHADO(65, "Pedido - Itens Detalhado"),
    CLIENTE(70, "Cliente"),
    REPRESENTANTE_CLIENTE(80, "Representante - Cliente"),
    VOUCHER(90, "Voucher"),
    CLIENTES_REPRESENTANTE(100, "Clientes - Representante"),
    BLOQUEIO_DE_REFERENCIAS(110, "Bloqueio de Referências"),
    BOLETOS_LISTAGEM(200, "Boletos - Listagem"),
    BOLETOS_DETALHADO(210, "Boletos - Detalhado"),
    BOLETOS_CONSULTA_CLIENTE(220, "Boletos - Consulta Cliente"),
    DANFE_ITENS_DA_NOTA(230, "DANFE - Itens da nota"),
    DANFE_LISTAGEM(240, "DANFE - Listagem"),
    DANFE_XML(250, "DANFE - XML"),
    CONDICAO_VENDA(260, "Condição Venda"),
    LOTE_DE_FATURAMENTO(270, "Lote de Faturamento"),
    PRODUTO_SKU_COD_BARRAS(280, "Produto SKU - Cód. Barras"),
    PRECO_POR_VOLUME(285, "Preço por Volume"),
    REFERENCIA_ESTOQUE_PRODUTO_DATA(290, "Referência - Estoque Produto/Data"),
    FRETE(300, "Frete"),
    ESPELHO_NOTA_DE_DEVOLUCAO(310, "Espelho Nota de Devolução"),
    COMISSAO_POR_REPRES_CLIENTE_MARCA(320, "Comissão por Repres/Cliente/Marca"),
    SUBSTITUICAO_TRIBUTARIA(330, "Substituição Tributária"),
    PARTIDAS_DE_PEDIDOS(340, "Partidas de Pedidos"),
    CLIENTES_CREDITO_TROCA_EM_GARANTIA(341, "Clientes - Crédito troca em garantia"),
    LICENCIADOS_FORNECEDOR(348, "Licenciados - Fornecedor"),
    LICENCIADOS_PEDIDO_HISTORICO(350, "Licenciados - Pedido - Histórico"),
    LICENCIADOS_PEDIDO_ITENS(360, "Licenciados - Pedido - Itens"),
    LICENCIADOS_DANFE_LISTAGEM(370, "Licenciados - DANFE - Listagem"),
    LICENCIADOS_DANFE_XML(380, "Licenciados - DANFE - XML"),
    TABELA_DE_PRECO(390, "Tabela de Preço"),
    NOTA_DE_DEVOLUCAO_INTEGRAL(315, "Nota de Devolução Integral");

    private final int value;
    private final String description;

    GeoB2bScriptEnum(int value, String description) {
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