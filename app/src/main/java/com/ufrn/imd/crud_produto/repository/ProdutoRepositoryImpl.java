package com.ufrn.imd.crud_produto.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.ufrn.imd.crud_produto.dto.ProdutoDTO;




public class ProdutoRepositoryImpl extends SQLiteOpenHelper implements ProdutoRepository{

    private final String colunaCodigoProduto = "codigo_produto";
    private final String colunaNomeProduto = "nome_produto";
    private final String colunaDescricaoProduto = "descricao_produto";
    private final String colunaQuantidadeEstoqueProduto = "quantidade_estoque_produto";
    private final String tabelaProdutos = "produto";
    private static SQLiteDatabase bancoDeDados;

    public ProdutoRepositoryImpl(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createDatabase = "CREATE TABLE " + tabelaProdutos +"(id_produto INTEGER PRIMARY KEY AUTOINCREMENT, " + colunaCodigoProduto + " VARCHAR(13) UNIQUE, " +
                colunaNomeProduto + " VARCHAR(50), " + colunaDescricaoProduto + " TEXT, " + colunaQuantidadeEstoqueProduto + " INT)";

        sqLiteDatabase.execSQL(createDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void registrarProduto(ProdutoDTO produtoDTO){
        bancoDeDados = this.getWritableDatabase();
        ContentValues registroDeProduto = new ContentValues();

        registroDeProduto.put(colunaCodigoProduto, produtoDTO.getCodigo());
        registroDeProduto.put(colunaNomeProduto, produtoDTO.getNome());
        registroDeProduto.put(colunaDescricaoProduto, produtoDTO.getDescricao());
        registroDeProduto.put(colunaQuantidadeEstoqueProduto, produtoDTO.getQuantidadeEstoque());

        bancoDeDados.insert(tabelaProdutos, null, registroDeProduto);
    }

    public Cursor retornarProdutos(){
        bancoDeDados = this.getReadableDatabase();
        String querySelectProdutos = "SELECT " + colunaCodigoProduto + ", " + colunaNomeProduto + ", "
                + colunaDescricaoProduto + ", " + colunaQuantidadeEstoqueProduto + " FROM produto";

        return bancoDeDados.rawQuery(querySelectProdutos, null);
    }

    public Cursor buscarProdutoPorCodigo(String codigoProduto){
        bancoDeDados = this.getReadableDatabase();
        String querySelectProdutos = "SELECT * FROM " + tabelaProdutos + " Where "
                + colunaCodigoProduto + "=" + codigoProduto;

        return bancoDeDados.rawQuery(querySelectProdutos, null);
    }

    public void alterarProduto(ProdutoDTO produtoDTO){
        bancoDeDados = this.getWritableDatabase();
        ContentValues registroDeProduto = new ContentValues();

        registroDeProduto.put(colunaNomeProduto, produtoDTO.getNome());
        registroDeProduto.put(colunaDescricaoProduto, produtoDTO.getDescricao());
        registroDeProduto.put(colunaQuantidadeEstoqueProduto, produtoDTO.getQuantidadeEstoque());

        String where = colunaCodigoProduto + "=" + produtoDTO.getCodigo();
        bancoDeDados.update(tabelaProdutos, registroDeProduto, where, null);
    }

    public void deletarProduto(String codigoProduto) {
        bancoDeDados = this.getWritableDatabase();
        String where = colunaCodigoProduto + "=" + codigoProduto;
        bancoDeDados.delete(tabelaProdutos, where, null);
    }

}
