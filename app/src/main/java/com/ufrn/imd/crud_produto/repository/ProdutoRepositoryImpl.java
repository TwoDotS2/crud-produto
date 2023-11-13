package com.ufrn.imd.crud_produto.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ProdutoRepositoryImpl extends SQLiteOpenHelper {

    public void ProdutoRepositoryImpl(){

    }
    public ProdutoRepositoryImpl(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE produto(id_produto INT PRIMARY KEY AUTOINCREMENT, codigo_produto VARCHAR(13) UNIQUE, nome_produto VARCHAR(50), descricao_produto TEXT, quantidade_estoque_produto INT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void registrarProduto(String codigoProduto, String nomeProduto, String descricaoProduto, Integer quantidadeEstoqueProduto){
        SQLiteDatabase bancoDeDados = this.getWritableDatabase();
        ContentValues registroDeProduto = new ContentValues();

        registroDeProduto.put("codigo_produto", codigoProduto);
        registroDeProduto.put("nome_produto", nomeProduto);
        registroDeProduto.put("descricao_produto", descricaoProduto);
        registroDeProduto.put("quantidade_produto", quantidadeEstoqueProduto);

        bancoDeDados.insert("produto", null, registroDeProduto);
        bancoDeDados.close();
    }
}
