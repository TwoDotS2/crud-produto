package com.ufrn.imd.crud_produto.controller;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ufrn.imd.crud_produto.R;

public class ListarProdutosActivityController extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_produtos);
    }
}