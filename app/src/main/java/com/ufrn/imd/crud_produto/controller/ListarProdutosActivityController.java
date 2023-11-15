package com.ufrn.imd.crud_produto.controller;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ufrn.imd.crud_produto.R;
import com.ufrn.imd.crud_produto.dto.ProdutoDTO;
import com.ufrn.imd.crud_produto.service.ProdutoService;

import java.util.ArrayList;

public class ListarProdutosActivityController extends AppCompatActivity {
    private ListView listViewProdutosCadastrados;
    private Button buttonVoltar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_produtos);
        inicializarComponentes();

        ProdutoService produtoService = new ProdutoService(getApplicationContext());
        ArrayList<ProdutoDTO> produtosDTO = produtoService.retornarProdutos();

        //TODO: descobrir como criar itens no listView
    }

    private void inicializarComponentes() {
        buttonVoltar = (Button) this.findViewById(R.id.buttonVoltar);
        listViewProdutosCadastrados = (ListView) this.findViewById(R.id.listViewProdutosCadastrados);
    }

}
