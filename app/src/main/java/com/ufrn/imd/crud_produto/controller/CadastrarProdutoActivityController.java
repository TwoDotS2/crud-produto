package com.ufrn.imd.crud_produto.controller;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ufrn.imd.crud_produto.R;
import com.ufrn.imd.crud_produto.service.CadastrarProdutoService;

public class CadastrarProdutoActivityController extends AppCompatActivity {
    public Button buttonSalvarCadastroProduto;
    public Button buttonLimparCadastroProduto;
    public EditText editTextCodigoCadastroProduto;
    public EditText editTextNomeCadastroProduto;
    public EditText editTextDescricaoCadastroProduto;
    public EditText editTextEstoqueCadastroProduto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_produto);
        inicializarComponentes();


        buttonLimparCadastroProduto.setOnClickListener(view -> {
            editTextCodigoCadastroProduto.setText("");
            editTextEstoqueCadastroProduto.setText("");
            editTextCodigoCadastroProduto.setText("");
            editTextNomeCadastroProduto.setText("");
        });

        CadastrarProdutoService cadastrarProdutoService = new CadastrarProdutoService(getApplicationContext());

        buttonSalvarCadastroProduto.setOnClickListener(view -> {
            String codigoProduto = editTextCodigoCadastroProduto.getText().toString();
            String nomeProduto = editTextNomeCadastroProduto.getText().toString();
            String descricaoProduto = editTextDescricaoCadastroProduto.getText().toString();
            String aux = editTextEstoqueCadastroProduto.getText().toString();
            Integer estoqueProduto = Integer.parseInt(aux);

            cadastrarProdutoService.registarProduto(codigoProduto, nomeProduto, descricaoProduto, estoqueProduto);
        });
    }

    private void inicializarComponentes() {
        buttonSalvarCadastroProduto = (Button) this.findViewById(R.id.buttonSalvarCadastroProduto);
        buttonLimparCadastroProduto = (Button) this.findViewById(R.id.buttonLimparCadastroProduto);
        editTextCodigoCadastroProduto = (EditText) this.findViewById(R.id.editTextCodigoCadastroProduto);
        editTextNomeCadastroProduto = (EditText) this.findViewById(R.id.editTextNomeCadastroProduto);
        editTextDescricaoCadastroProduto = (EditText) this.findViewById(R.id.editTextDescricaoCadastroProduto);
        editTextEstoqueCadastroProduto = (EditText) this.findViewById(R.id.editTextEstoqueCadastroProduto);
    }


}
