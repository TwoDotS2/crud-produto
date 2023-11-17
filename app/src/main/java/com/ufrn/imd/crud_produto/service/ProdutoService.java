package com.ufrn.imd.crud_produto.service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;

import com.ufrn.imd.crud_produto.dto.ProdutoDTO;
import com.ufrn.imd.crud_produto.repository.ProdutoRepositoryImpl;

import java.util.ArrayList;

public class ProdutoService {
    private Context contextoApp;
    private ProdutoRepositoryImpl produtoRepository;
    public ProdutoService(Context context){
        contextoApp = context;
    }

    public void registarProduto(ProdutoDTO produtoDTO) throws SQLiteConstraintException{
        produtoRepository = new ProdutoRepositoryImpl(contextoApp, "produto", null, 1);

        Cursor cursor =  produtoRepository.buscarProdutoPorCodigo(produtoDTO.getCodigo());
        if (cursor.getCount() == 0) {
            produtoRepository.registrarProduto(produtoDTO);
        } else {
            throw new SQLiteConstraintException("Produto já cadastrado");
        }
    }

    public ArrayList<ProdutoDTO> retornarProdutos(){
        produtoRepository = new ProdutoRepositoryImpl(contextoApp, "produto", null, 1);
        Cursor cursor = produtoRepository.retornarProdutos();
        ArrayList<ProdutoDTO> produtos = new ArrayList<ProdutoDTO>();

        //TODO: Transformar em enum
        final int indiceCodigoProduto = cursor.getColumnIndex("codigo_produto");
        final int indiceNomeProduto = cursor.getColumnIndex("nome_produto");
        final int indiceDescricaoProduto = cursor.getColumnIndex("descricao_produto");
        final int indiceQuantidadeEstoqueProduto = cursor.getColumnIndex("quantidade_estoque_produto");

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

    public void alterarProduto(ProdutoDTO produtoDTO) throws Exception{
        produtoRepository = new ProdutoRepositoryImpl(contextoApp, "produto", null, 1);

        Cursor cursor = produtoRepository.buscarProdutoPorCodigo(produtoDTO.getCodigo());

        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            produtoRepository.alterarProduto(produtoDTO);
        }
        else {
            throw new Exception("Produto não existe");
        }
    }

    public void deletarProduto(String codigoProduto) throws Exception{
        produtoRepository = new ProdutoRepositoryImpl(contextoApp, "produto", null, 1);

        Cursor cursor = produtoRepository.buscarProdutoPorCodigo(codigoProduto);

        if (cursor.getCount() !=0){
            cursor.moveToFirst();
            produtoRepository.deletarProduto(codigoProduto);
        } else {
            throw new Exception("Produto não existe");
        }
    }



}
