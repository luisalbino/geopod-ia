package com.application.enums;

public enum GeoForcaVendasScriptEnum {
    FV_TABELA_DE_PRECO(10, "Tabela de Preço"),
    FV_TABELA_DE_PRECO_POR_REPRESENTANTE(15, "Tabela de Preço por Representante"),
    FV_TABELA_DE_PRECO_POLITICA(17, "Tabela de Preço - Política"),
    FV_TABELA_DE_PRECO_PRODUTO(20, "Tabela de Preço - Produto"),
    FV_TABELA_DE_PRECO_SKU(20001, "Tabela de Preço - SKU"),
    FV_TABELA_DE_PRECO_COLECAO_DE_PARA(21, "Tabela de Preço - Coleção De/Para"),
    FV_TABELA_DE_PRECO_REPRESENTANTE_DE_PARA(22, "Tabela de Preço - Representante De/Para"),
    FV_TABELA_DE_PRECO_CLIENTE_DE_PARA(23, "Tabela de Preço - Cliente De/Para"),
    FV_TABELA_DE_PRECO_POLITICA_DESCONTO_COMERCIAL(24, "Tabela de Preço - Política - Desconto Comercial"),
    FV_TABELA_DE_PRECO_POLITICA_DESCONTO_FINANCEIRO(25, "Tabela de Preço - Política - Desconto Financeiro"),
    FV_TABELA_DE_PRECO_POLITICA_DESCONTO_ANTECIPACAO(26, "Tabela de Preço - Política - Desconto Antecipação"),
    FV_TABELA_DE_PRECO_POLITICA_PRAZO_ADICIONAL(27, "Tabela de Preço - Política - Prazo Adicional"),
    FV_TABELA_DE_PRECO_POLITICA_CAPA(28, "Tabela de Preço - Política - Capa"),
    FV_TABELA_DE_PRECO_POLITICA_DESCONTO_12_ACRESCIMO_FINANCEIRO(29, "Tabela de Preço - Política - Desconto 12 - Acréscimo Financeiro"),
    FV_TABELA_DE_PRECO_POLITICA_DESCONTO_13_SEGMENTO(29001, "Tabela de Preço - Política - Desconto 13 - Segmento"),
    FV_TABELA_DE_PRECO_POLITICA_DESCONTO_12_ADICIONAL_LOTE(29002, "Tabela de Preço - Política - Desconto 12 - Adicional Lote"),
    FV_TABELA_DE_PRECO_POLITICA_FAIXAS_PRAZO_MEDIO(29003, "Tabela de Preço - Política - Faixas Prazo Médio"),
    FV_TITULOS(30, "Títulos"),
    FV_CONDICAO_DE_VENDA(40, "Condição de Venda"),
    FV_TIPO_DE_NOTA(50, "Tipo de Nota"),
    FV_PORTADOR(53, "Portador"),
    FV_TIPO_DE_ENTREGA(55, "Tipo de Entrega"),
    FV_TIPO_DE_COBRANCA(57, "Tipo de Cobrança"),
    FV_COMISSOES(60, "Comissões"),
    FV_COMISSOES_EXTRATO_RESUMO(63, "Comissões - Extrato Resumo"),
    FV_COMISSOES_EXTRATO_DETALHADO(65, "Comissões - Extrato Detalhado"),
    FV_COMISSOES_EXTRATO_V2_RESUMO(67, "Comissões - Extrato V2 Resumo"),
    FV_COMISSOES_EXTRATO_V2_DETALHADO(68, "Comissões - Extrato V2 Detalhado"),
    FV_COTA_DE_ESTOQUE_POR_REPRESENTANTE(69, "Cota de estoque - Por representante"),
    FV_CLIENTES(70, "Clientes"),
    FV_CLIENTES_POR_CNPJ(71, "Clientes por CNPJ"),
    FV_CLIENTES_REFERENCIAS_COMERCIAIS(72, "Clientes - Referências Comercias"),
    FV_CLIENTES_CONTATOS(73, "Clientes - Contatos"),
    FV_CLIENTES_CAMPOS_CUSTOMIZADOS(74, "Clientes - Campos Customizados"),
    FV_CLIENTES_LOCAIS_DE_ENTREGA(75, "Clientes - Locais de Entrega"),
    FV_CLIENTES_TRIANGULACAO(7501, "Clientes - Triangulação"),
    FV_CLIENTES_CONDICOES_DE_VENDA(7601, "Clientes - Condições de venda"),
    FV_RAMOS_DE_ATIVIDADE(76, "Ramos de Atividade"),
    FV_GRUPOS_DE_CLIENTE(77, "Grupos de Cliente"),
    FV_MARCAS(7701, "Marcas"),
    FV_MARCAS_CONCORRENTES(7702, "Marcas Concorrentes"),
    FV_CLIENTES_RECORRENTES(78, "Clientes Recorrentes"),
    FV_CLIENTES_CONTATOS_DEPARTAMENTO(79, "Clientes - Contatos - Departamento"),
    FV_PRODUTOS(80, "Produtos"),
    FV_PRODUTOS_GRADES(83, "Produtos - Grades"),
    FV_PRODUTOS_SORTIMENTOS(85, "Produtos - Sortimentos"),
    FV_PRODUTOS_FAMILIA_SORTIMENTOS(86, "Produtos - Família Sortimentos"),
    FV_PRODUTOS_CODIGO_REDUZIDO(87, "Produtos - Código Reduzido"),
    FV_PRODUTOS_CODIGOS_EAN13(88, "Produtos - Códigos EAN13"),
    FV_PRODUTOS_IMAGENS_B2SPREFERENCIAIMAGEM(80001, "Produtos - Imagens - B2S Preferência Imagem"),
    FV_BLOQUEIO_DE_REFERENCIAS(89, "Bloqueio de Referências"),
    FV_PRODUTOS_LINHAS(90, "Produtos - Linhas"),
    FV_PRODUTOS_ETIQUETAS(92, "Produtos - Etiquetas"),
    FV_PRODUTOS_GENERO(93, "Produtos - Gênero"),
    FV_PRODUTOS_MODELOS(94, "Produtos - Modelos"),
    FV_PRODUTOS_TIPOS(96, "Produtos - Tipos"),
    FV_PRODUTOS_SKUS(97, "Produtos - SKUs"),
    FV_PRODUTOS_KEYWORDS(98, "Produtos - Keywords"),
    FV_PRODUTOS_UNIDADE_MEDIDA(99, "Produtos - Unidade de Medida"),
    FV_PEDIDOS_CAPA(100, "Pedidos - Capa"),
    FV_PEDIDOS_POR_REFERENCIA(115, "Pedidos - Por Referência"),
    FV_PEDIDOS_UUID(130, "Pedidos - UUID"),
    FV_PEDIDOS_UUID_EM_MASSA(135, "Pedidos - UUID em Massa"),
    FV_LISTAGEM_DE_PEDIDOS_CAPA(140, "Listagem de Pedidos - Capa"),
    FV_LISTAGEM_DE_PEDIDOS_EM_ABERTO_CAPA(141, "Listagem de Pedidos em Aberto - Capa"),
    FV_LISTAGEM_DE_PEDIDOS_DETALHADO(150, "Listagem de Pedidos - Detalhado"),
    FV_LISTAGEM_DE_PEDIDOS_EM_ABERTO_DETALHADO(151, "Listagem de Pedidos em Aberto - Detalhado"),
    FV_LISTAGEM_DE_PEDIDOS_ITENS(160, "Listagem de Pedidos - Itens"),
    FV_LISTAGEM_DE_PEDIDOS_ITENS_GRADE(161, "Listagem de Pedidos - Itens - Grade"),
    FV_LISTAGEM_DE_PEDIDOS_EM_ABERTO_ITENS(162, "Listagem de Pedidos em Aberto - Itens"),
    FV_LISTAGEM_DE_PEDIDOS_NOTAS(170, "Listagem de Pedidos - Notas"),
    FV_LISTAGEM_DE_PEDIDOS_OBSERVACOES(171, "Listagem de Pedidos - Observações"),
    FV_LISTAGEM_DE_PEDIDOS_HISTORICO(172, "Listagem de Pedidos - Histórico"),
    FV_LISTAGEM_DE_NOTAS_FISCAIS_CAPA(180, "Listagem de Notas Fiscais - Capa"),
    FV_ESTOQUE_ONLINE(200, "Estoque Online"),
    FV_ESTOQUE_ONLINE_LISTA_DE_ITENS_NO_PARAMETRO(201, "Estoque Online - Lista de Itens no Parâmetro"),
    FV_ESTOQUE_ONLINE_REPRESENTANTE(202, "Estoque Online - Representante"),
    FV_ESTOQUE_CONTA_CORRENTE(205, "Estoque - Conta Corrente"),
    FV_ROMANEIO_SEARCHOBJ(210, "Romaneio - SearchObj"),
    FV_ROMANEIO_ITENS(215, "Romaneio - Itens"),
    FV_LOTES_DE_ENTREGA(220, "Lotes de Entrega"),
    FV_LOTES_DE_FATURAMENTO(221, "Lotes de Faturamento"),
    FV_COMPRA_ACUMULADA_VALORES_BASE_CALCULO(230, "Compra Acumulada - Valores Base Cálculo"),
    FV_COMPRA_ACUMULADA_POLITICA_DE_DESCONTOS(231, "Compra Acumulada - Política de Descontos"),
    FV_FAIXA_CRESCIMENTO_VALORES_BASE_CALCULO_COLECAO_ANTERIOR(240, "Faixa de Crescimento - Valores Base Cálculo - Coleção Anterior"),
    FV_FAIXA_CRESCIMENTO_VALORES_BASE_CALCULO_COLECAO_ATUAL(241, "Faixa de Crescimento - Valores Base Cálculo - Coleção Atual"),
    FV_FAIXA_CRESCIMENTO_POLITICA_DE_DESCONTOS(242, "Faixa de Crescimento - Política de Descontos"),
    FV_VOLUME_COMPRA_POLITICA_DE_DESCONTOS(250, "Volume de Compra - Política de Descontos"),
    FV_DESCONTO_CAMPANHA_POLITICA_DE_DESCONTOS(251, "Desconto de Campanha - Política de Descontos"),
    FV_DESCONTO_LINHA_DE_PRODUTO_POLITICA_DE_DESCONTOS(252, "Desconto - Linha de Produto - Política de Descontos"),
    FV_TIPO_CLIENTE(260, "Tipo de Cliente"),
    FV_INDICADOR_FISCAL(261, "Indicador Fiscal"),
    FV_POLITICA_COLECAO(341, "Política - Coleção"),
    FV_PROGRAMA_CASHBACK_PARAMETROS(400, "Programa Cashback - Parâmetros"),
    FV_PROGRAMA_CASHBACK_VALORES_BASE_CALCULO(401, "Programa Cashback - Valores Base Cálculo"),
    FV_CALCULO_DE_ST_POR_PRODUTO_PARAMETROS(402, "Cálculo de ST por Produto - Parâmetros"),
    FV_CALCULO_DE_ST_POR_PRODUTO_GRUPOS_DE_CLIENTE(403, "Cálculo de ST por Produto - Grupos de Cliente"),
    FV_SUGESTAO_DE_DESCONTOS(430, "Sugestão de Descontos"),
    FV_CONTA_CORRENTE(431, "Conta Corrente"),
    FV_CONTA_CORRENTE_SITUACAO_PEDIDO(432, "Conta Corrente - Situação do Pedido"),
    FV_SKUS_PRONTA_ENTREGA_E_PROGRAMADO(444, "SKUs - Pronta Entrega e Programado"),
    FV_TABELA_DE_PRECO_POLITICA_PRECO_POR_VOLUME(450, "Tabela de Preço - Política - Preço por Volume"),
    FV_TAMANHOS(500, "Tamanhos"),
    FV_VALOR_DE_FRETE(555, "Valor de Frete"),
    FV_CLIENTES_TIPO_NOTA(776, "Clientes - Tipo de Nota"),
    FV_PEDIDOS_POR_DATA_DE_LOTE_FATUR(800, "Pedidos - Por Data de Lote Fatur."),
    FV_INTERNACIONALIZACAO_REFERENCIAS(801, "Internacionalização - Referências"),
    FV_INTERNACIONALIZACAO_CORES(802, "Internacionalização - Cores"),
    FV_INTERNACIONALIZACAO_COLECOES(803, "Internacionalização - Coleções"),
    FV_INTERNACIONALIZACAO_TIPOS_DE_PRODUTO(804, "Internacionalização - Tipos de Produto"),
    FV_INTERNACIONALIZACAO_MODELOS_DE_PRODUTO(805, "Internacionalização - Modelos de Produto"),
    FV_INTERNACIONALIZACAO_MARCAS_DE_PRODUTO(806, "Internacionalização - Marcas de Produto"),
    FV_INTERNACIONALIZACAO_LINHAS_DE_PRODUTO(807, "Internacionalização - Linhas de Produto"),
    FV_INTERNACIONALIZACAO_STATUS_DE_PEDIDOS(808, "Internacionalização - Status de Pedidos"),
    FV_CLASSIFICACAO_DE_PEDIDOS(810, "Classificação de Pedidos"),
    FV_CLIENTES_INDICADORES(809, "Clientes - Indicadores"),
    FV_CLIENTES_REPOSICAO(811, "Clientes - Reposição"),
    FV_ACESSORIOS_PRODUTOS(901, "Acessórios - Produtos"),
    FV_LA_BELLA_MAFIA_CLIENTES_PARA_ATUALIZAR(902, "La Bella Mafia - Clientes para Atualizar"),
    FV_PRODUTOS_GOLD_BE(903, "Produtos - Gold Be"),
    FV_PRODUTOS_PARTE_CIMA_PARTE_BAIXO(904, "Produtos - Parte Cima/Parte Baixo"),
    FV_PRODUTOS_DATA_DE_ENTREGA(905, "Produtos - Data de Entrega"),
    FV_PRODUTOS_PRIORIDADE_DE_LINHA_PARA_DISTRIBUICAO(910, "Produtos - Prioridade de Linha para Distribuição");

    private final int value;
    private final String description;

    GeoForcaVendasScriptEnum(int value, String description) {
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
