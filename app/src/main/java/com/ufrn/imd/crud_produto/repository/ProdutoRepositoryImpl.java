package com.ufrn.imd.crud_produto.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.ufrn.imd.crud_produto.dto.ProdutoDTO;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepositoryImpl extends SQLiteOpenHelper {

    private final String colunaCodigoProduto = "codigo_produto";
    private final String colunaNomeProduto = "nome_produto";
    private final String colunaDescricaoProduto = "descricao_produto";
    private final String colunaQuantidadeEstoqueProduto = "quantidade_estoque_produto";
    private final String tabelaProduto = "produto";

    public ProdutoRepositoryImpl(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createDatabase = "CREATE TABLE " + tabelaProduto +"(id_produto INTEGER PRIMARY KEY AUTOINCREMENT, " + colunaCodigoProduto + " VARCHAR(13) UNIQUE, " +
                colunaNomeProduto + " VARCHAR(50), " + colunaDescricaoProduto + " TEXT, " + colunaQuantidadeEstoqueProduto + " INT NOT NULL)";

        sqLiteDatabase.execSQL(createDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void registrarProduto(ProdutoDTO produtoDTO){
        SQLiteDatabase bancoDeDados = this.getWritableDatabase();
        ContentValues registroDeProduto = new ContentValues();

        registroDeProduto.put(colunaCodigoProduto, produtoDTO.getCodigo());
        registroDeProduto.put(colunaNomeProduto, produtoDTO.getNome());
        registroDeProduto.put(colunaDescricaoProduto, produtoDTO.getDescricao());
        registroDeProduto.put(colunaQuantidadeEstoqueProduto, produtoDTO.getQuantidadeEstoque());

        bancoDeDados.insert(tabelaProduto, null, registroDeProduto);
        bancoDeDados.close();
    }

    public Cursor retornarProdutos(){
        SQLiteDatabase bancoDeDados = this.getReadableDatabase();
        String querySelectProdutos = "SELECT " + colunaCodigoProduto + ", " + colunaNomeProduto + ", "
                + colunaDescricaoProduto + ", " + colunaQuantidadeEstoqueProduto + " FROM produto";

        Cursor produtos = null;
        if(bancoDeDados != null){
            produtos = bancoDeDados.rawQuery(querySelectProdutos, null);
        }

        produtos.close();
        return produtos;
    }
}
