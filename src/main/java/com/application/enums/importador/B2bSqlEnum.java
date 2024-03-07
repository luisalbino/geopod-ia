package com.application.enums.importador;

public enum B2bSqlEnum {
    B2B_REFERENCIA(10, "Referência"),
    B2B_REFERENCIA_GRADE(20, "Referência - Grade"),
    B2B_REFERENCIA_GRADE_FECHADA(21, "Referência - Grade Fechada"),
    B2B_REFERENCIA_SORTIMENTO(30, "Referência - Sortimento"),
    B2B_REFERENCIA_PRECOS(40, "Referência - Preços"),
    B2B_REFERENCIA_PRECOS_SKU(45, "Referência - Preços - SKU"),
    B2B_REFERENCIA_ESTOQUE(50, "Referência - Estoque"),
    B2B_REFERENCIA_ESTOQUE_PARCIAL(55, "Referência - Estoque Parcial"),
    B2B_REFERENCIA_POCKET(56, "Referência - Pocket"),
    B2B_PEDIDO_CAPA(60, "Pedido - Capa"),
    B2B_PEDIDO_HISTORICO(61, "Pedido - Histórico"),
    B2B_PEDIDO_DETALHE(62, "Pedido - Detalhe"),
    B2B_PEDIDO_ITENS(63, "Pedido - Itens"),
    B2B_PEDIDO_RECOMPRA(64, "Pedido - Recompra"),
    B2B_PEDIDO_ITENS_DETALHADO(65, "Pedido - Itens Detalhado"),
    B2B_CLIENTE(70, "Cliente"),
    B2B_REPRESENTANTE_CLIENTE(80, "Representante - Cliente"),
    B2B_VOUCHER(90, "Voucher"),
    B2B_CLIENTES_REPRESENTANTE(100, "Clientes - Representante"),
    B2B_BLOQUEIO_DE_REFERENCIAS(110, "Bloqueio de Referências"),
    B2B_BOLETOS_LISTAGEM(200, "Boletos - Listagem"),
    B2B_BOLETOS_DETALHADO(210, "Boletos - Detalhado"),
    B2B_BOLETOS_CONSULTA_CLIENTE(220, "Boletos - Consulta Cliente"),
    B2B_DANFE_ITENS_DA_NOTA(230, "DANFE - Itens da nota"),
    B2B_DANFE_LISTAGEM(240, "DANFE - Listagem"),
    B2B_DANFE_XML(250, "DANFE - XML"),
    B2B_CONDICAO_VENDA(260, "Condição Venda"),
    B2B_LOTE_DE_FATURAMENTO(270, "Lote de Faturamento"),
    B2B_PRODUTO_SKU_COD_BARRAS(280, "Produto SKU - Cód. Barras"),
    B2B_PRECO_POR_VOLUME(285, "Preço por Volume"),
    B2B_REFERENCIA_ESTOQUE_PRODUTO_DATA(290, "Referência - Estoque Produto/Data"),
    B2B_FRETE(300, "Frete"),
    B2B_ESPELHO_NOTA_DE_DEVOLUCAO(310, "Espelho Nota de Devolução"),
    B2B_COMISSAO_POR_REPRES_CLIENTE_MARCA(320, "Comissão por Repres/Cliente/Marca"),
    B2B_SUBSTITUICAO_TRIBUTARIA(330, "Substituição Tributária"),
    B2B_PARTIDAS_DE_PEDIDOS(340, "Partidas de Pedidos"),
    B2B_CLIENTES_CREDITO_TROCA_EM_GARANTIA(341, "Clientes - Crédito troca em garantia"),
    B2B_LICENCIADOS_FORNECEDOR(348, "Licenciados - Fornecedor"),
    B2B_LICENCIADOS_PEDIDO_HISTORICO(350, "Licenciados - Pedido - Histórico"),
    B2B_LICENCIADOS_PEDIDO_ITENS(360, "Licenciados - Pedido - Itens"),
    B2B_LICENCIADOS_DANFE_LISTAGEM(370, "Licenciados - DANFE - Listagem"),
    B2B_LICENCIADOS_DANFE_XML(380, "Licenciados - DANFE - XML"),
    B2B_TABELA_DE_PRECO(390, "Tabela de Preço"),
    B2B_NOTA_DE_DEVOLUCAO_INTEGRAL(315, "Nota de Devolução Integral");

    private final int codigo;
    private final String descricao;

    B2bSqlEnum(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getModulo() {return ModuloEnum.B2B.getCodigo();}

}