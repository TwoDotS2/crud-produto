package com.ufrn.imd.crud_produto.controller;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ufrn.imd.crud_produto.R;

public class MenuPrincipalActivity extends AppCompatActivity {

    private Button buttonCadastrar;
    private Button buttonAlterar;
    private Button buttonListar;
    private Button buttonDeletar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        inicializarComponentes();

        buttonCadastrar.setOnClickListener(view -> {
            Intent intentCadastrarProduto = new Intent(MenuPrincipalActivity.this, CadastrarProdutoActivity.class);
            startActivity(intentCadastrarProduto);
        });

        buttonAlterar.setOnClickListener(view -> {
            Intent intentAlterarProduto = new Intent(MenuPrincipalActivity.this, AlterarProdutoActivity.class);
            startActivity(intentAlterarProduto);
        });

        buttonDeletar.setOnClickListener(view -> {
            Intent intentDeletarProduto = new Intent(MenuPrincipalActivity.this, DeletarProdutoActivity.class);
            startActivity(intentDeletarProduto);
        });

        buttonListar.setOnClickListener(view -> {
            Intent intentListarProduto = new Intent(MenuPrincipalActivity.this, ListarProdutosActivity.class);
            startActivity(intentListarProduto);
        });
    }

    private void inicializarComponentes() {
        buttonCadastrar = this.findViewById(R.id.buttonCadastrar);
        buttonAlterar = this.findViewById(R.id.buttonAlterar);
        buttonListar = this.findViewById(R.id.buttonListar);
        buttonDeletar = this.findViewById(R.id.buttonDeletar);
    }
}
