package com.ufrn.imd.crud_produto.repository;

import android.database.Cursor;

import com.ufrn.imd.crud_produto.dto.ProdutoDTO;

public interface ProdutoRepository {
    public void registrarProduto(ProdutoDTO produtoDTO);
    public Cursor buscarProdutoPorCodigo(String codigoProduto);
    public void alterarProduto(ProdutoDTO produtoDTO);
    public void deletarProduto(String codigoProduto);
}
