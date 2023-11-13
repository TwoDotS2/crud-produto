package com.ufrn.imd.crud_produto.controller;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ufrn.imd.crud_produto.R;

public class MenuPrincipalActivityController extends AppCompatActivity {

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
            Intent intentCadastrarProduto = new Intent(MenuPrincipalActivityController.this, CadastrarProdutoActivityController.class);
            startActivity(intentCadastrarProduto);
        });

        buttonAlterar.setOnClickListener(view -> {
            Intent intentAlterarProduto = new Intent(MenuPrincipalActivityController.this, AlterarProdutoActivityController.class);
            startActivity(intentAlterarProduto);
        });

        buttonDeletar.setOnClickListener(view -> {
            Intent intentDeletarProduto = new Intent(MenuPrincipalActivityController.this, DeletarProdutoActivityController.class);
            startActivity(intentDeletarProduto);
        });

        buttonListar.setOnClickListener(view -> {
            Intent intentListarProduto = new Intent(MenuPrincipalActivityController.this, ListarProdutosActivityController.class);
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
