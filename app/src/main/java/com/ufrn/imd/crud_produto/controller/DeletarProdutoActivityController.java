package com.ufrn.imd.crud_produto.controller;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ufrn.imd.crud_produto.R;
import com.ufrn.imd.crud_produto.dto.ProdutoDTO;
import com.ufrn.imd.crud_produto.service.ProdutoService;

public class DeletarProdutoActivityController extends AppCompatActivity {

    private Button buttonDeletarProduto;
    private Button buttonLimparProduto;
    private EditText editTextCodigoDeletarProduto;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletar_produto);
        inicializarComponentes();

        buttonLimparProduto.setOnClickListener(view -> {
            editTextCodigoDeletarProduto.setText("");
        });

        ProdutoService produtoService = new ProdutoService(getApplicationContext());

        buttonDeletarProduto.setOnClickListener(view -> {
            String codigoProduto = editTextCodigoDeletarProduto.getText().toString();

            if (!codigoProduto.isEmpty()) {

                try {
                    produtoService.deletarProduto(codigoProduto);
                    Toast.makeText(getApplicationContext(), "Produto deletado!", Toast.LENGTH_LONG).show();
                    voltarParaMenuPrincipal();

                } catch (Exception e){
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    voltarParaMenuPrincipal();
                }

            } else {
                Toast.makeText(getApplicationContext(), "'Código' não preenchido!", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void inicializarComponentes() {
        buttonDeletarProduto = this.findViewById(R.id.buttonDeletarProduto);
        buttonLimparProduto = this.findViewById(R.id.buttonLimparDeletarProduto);
        editTextCodigoDeletarProduto = this.findViewById(R.id.editTextCodigoDeletarProduto);
    }

    private void voltarParaMenuPrincipal(){
        Intent intentMenuPrincipal = new Intent(this, MenuPrincipalActivityController.class);
        startActivity(intentMenuPrincipal);
    }
}
