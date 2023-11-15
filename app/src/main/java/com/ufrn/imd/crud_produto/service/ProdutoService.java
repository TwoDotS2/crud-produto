package com.ufrn.imd.crud_produto.service;

import android.content.Context;
import android.database.Cursor;

import com.ufrn.imd.crud_produto.dto.ProdutoDTO;
import com.ufrn.imd.crud_produto.repository.ProdutoRepositoryImpl;

import java.util.ArrayList;

public class ProdutoService {
    private Context contextoApp;
    private ProdutoRepositoryImpl produtoRepository;
    public ProdutoService(Context context){
        contextoApp = context;
        produtoRepository = new ProdutoRepositoryImpl(contextoApp, "produto", null, 1);
    }

    public void registarProduto(ProdutoDTO produtoDTO) {
        produtoRepository.registrarProduto(produtoDTO);
    }

    public ArrayList<ProdutoDTO> retornarProdutos(){
        Cursor cursor = produtoRepository.retornarProdutos();
        ArrayList<ProdutoDTO> produtos = new ArrayList<ProdutoDTO>();

        final Integer indiceCodigoProduto = cursor.getColumnIndex("codigo_produto");
        final Integer indiceNomeProduto = cursor.getColumnIndex("nome_produto");
        final Integer indiceDescricaoProduto = cursor.getColumnIndex("descricao_produto");
        final Integer indiceQuantidadeEstoqueProduto = cursor.getColumnIndex("quantidade_estoque_produto");

        while (cursor.moveToNext()) {
            ProdutoDTO produtoDTO = new ProdutoDTO();
            produtoDTO.setCodigo(cursor.getString(indiceCodigoProduto));
            produtoDTO.setNome(cursor.getString(indiceNomeProduto));
            produtoDTO.setDescricao(cursor.getString(indiceDescricaoProduto));
            produtoDTO.setQuantidadeEstoque(cursor.getInt(indiceQuantidadeEstoqueProduto));

            produtos.add(produtoDTO);
        }

        return produtos;
    }
}
