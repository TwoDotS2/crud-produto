package com.ufrn.imd.crud_produto.service;

import android.content.Context;

import com.ufrn.imd.crud_produto.repository.ProdutoRepositoryImpl;

public class CadastrarProdutoService {
    private Context contextoApp;
    private ProdutoRepositoryImpl produtoRepository = new ProdutoRepositoryImpl(contextoApp, "produto", null, 1);
    public CadastrarProdutoService(Context context){
        contextoApp = context;
    }

    //TODO: implementar regras de cadastro de produto
    public void registarProduto(String codigoProduto, String nomeProduto, String descricaoProduto, Integer estoqueProduto) {
        if (!codigoProduto.isEmpty() && !nomeProduto.isEmpty()){

        }
    }
}
