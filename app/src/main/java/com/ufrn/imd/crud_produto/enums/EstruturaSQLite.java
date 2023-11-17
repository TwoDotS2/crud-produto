package com.ufrn.imd.crud_produto.enums;

public enum EstruturaSQLite {
    COLUNA_CODIGO_PRODUTO("codigo_produto"),
    COLUNA_NOME_PRODUTO("nome_produto"),
    COLUNA_DESCRICAO_PRODUTO("descricao_produto"),
    COLUNA_QUANTIDADE_ESTOQUE("quantidade_estoque_produto"),
    TABELA_PRODUTO("produto");

    EstruturaSQLite(String descricaoComponente){}


}
