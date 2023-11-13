package com.ufrn.imd.crud_produto.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UsuarioRepositoryImpl extends SQLiteOpenHelper {


    public UsuarioRepositoryImpl(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE usuario(id INT PRIMARY KEY, login VARCHAR(50) UNIQUE, senha VARCHAR(50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void registrarUsuario(String login, String senha){
        SQLiteDatabase bancoUsuario = this.getWritableDatabase();
        ContentValues registroDeUsuario = new ContentValues();
        registroDeUsuario.put("login", login);
        registroDeUsuario.put("senha", senha);
        bancoUsuario.insert("usuario", null, registroDeUsuario);
        bancoUsuario.close();
    }
}
