package com.ufrn.imd.crud_produto.controller;

import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ufrn.imd.crud_produto.R;
import com.ufrn.imd.crud_produto.dto.ProdutoDTO;
import com.ufrn.imd.crud_produto.service.ProdutoService;

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
            editTextDescricaoCadastroProduto.setText("");
            editTextNomeCadastroProduto.setText("");
        });

        ProdutoService produtoService = new ProdutoService(getApplicationContext());

        buttonSalvarCadastroProduto.setOnClickListener(view -> {
            String codigoProduto = editTextCodigoCadastroProduto.getText().toString();
            String nomeProduto = editTextNomeCadastroProduto.getText().toString();
            String descricaoProduto = editTextDescricaoCadastroProduto.getText().toString();

            Integer quantidadeEstoqueProduto;
            String aux = editTextEstoqueCadastroProduto.getText().toString();

            if(aux.isEmpty())
                quantidadeEstoqueProduto = null;
            else
                quantidadeEstoqueProduto = Integer.parseInt(aux);

            if (!codigoProduto.isEmpty() && !nomeProduto.isEmpty() &&
                !descricaoProduto.isEmpty() && quantidadeEstoqueProduto != null) {

                ProdutoDTO produtoDTO = new ProdutoDTO(codigoProduto, nomeProduto, descricaoProduto, quantidadeEstoqueProduto);

                try {
                    produtoService.registarProduto(produtoDTO);
                    Toast.makeText(getApplicationContext(), "Produto cadastrado com sucesso!", Toast.LENGTH_LONG).show();
                    voltarParaMenuPrincipal();

                } catch (SQLiteConstraintException e){
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    voltarParaMenuPrincipal();

                }

            } else {
                String erro = "Preencha todos os itens";
                Toast.makeText(getApplicationContext(), erro, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void inicializarComponentes() {
        buttonSalvarCadastroProduto = (Button) this.findViewById(R.id.buttonDeletarProduto);
        buttonLimparCadastroProduto = (Button) this.findViewById(R.id.buttonLimparDeletarProduto);
        editTextCodigoCadastroProduto = (EditText) this.findViewById(R.id.editTextCodigoDeletarProduto);
        editTextNomeCadastroProduto = (EditText) this.findViewById(R.id.editTextNomeAlteracaoProduto);
        editTextDescricaoCadastroProduto = (EditText) this.findViewById(R.id.editTextDescricaoAlteracaoProduto);
        editTextEstoqueCadastroProduto = (EditText) this.findViewById(R.id.editTextEstoqueAlteracaoProduto);
    }

    private void voltarParaMenuPrincipal(){
        Intent intentMenuPrincipal = new Intent(this, MenuPrincipalActivityController.class);
        startActivity(intentMenuPrincipal);
    }
}
