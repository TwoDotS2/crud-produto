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

public class AlterarProdutoActivityController extends AppCompatActivity {
    public Button buttonAlterarAlteracaoProduto;
    public Button buttonLimparAlteracaoProduto;
    public EditText editTextCodigoAlteracaoProduto;
    public EditText editTextNomeAlteracaoProduto;
    public EditText editTextDescricaoAlteracaoProduto;
    public EditText editTextEstoqueAlteracaoProduto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_produto);
        inicializarComponentes();

        ProdutoService produtoService = new ProdutoService(getApplicationContext());


        buttonLimparAlteracaoProduto.setOnClickListener(view -> {
            editTextCodigoAlteracaoProduto.setText("");
            editTextEstoqueAlteracaoProduto.setText("");
            editTextDescricaoAlteracaoProduto.setText("");
            editTextNomeAlteracaoProduto.setText("");
        });


        buttonAlterarAlteracaoProduto.setOnClickListener(view -> {
            String codigoProduto = editTextCodigoAlteracaoProduto.getText().toString();

            if (!codigoProduto.isEmpty()) {

                String nomeProduto = editTextNomeAlteracaoProduto.getText().toString();
                String descricaoProduto = editTextDescricaoAlteracaoProduto.getText().toString();
                Integer quantidadeEstoqueProduto;
                String aux = editTextEstoqueAlteracaoProduto.getText().toString();

                if(aux.isEmpty()){
                    quantidadeEstoqueProduto = null;
                }
                else {
                    quantidadeEstoqueProduto = Integer.parseInt(aux);
                }


                ProdutoDTO produtoDTO = new ProdutoDTO();

                produtoDTO.setCodigo(codigoProduto);
                produtoDTO.setNome(nomeProduto);
                produtoDTO.setDescricao(descricaoProduto);
                produtoDTO.setQuantidadeEstoque(quantidadeEstoqueProduto);


                try {
                    produtoService.alterarProduto(produtoDTO);
                    Toast.makeText(getApplicationContext(), "Produto alterado!", Toast.LENGTH_LONG).show();
                    voltarParaMenuPrincipal();

                } catch(Exception e){
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    voltarParaMenuPrincipal();
                    
                }

            } else {
                Toast.makeText(getApplicationContext(), "'Código' não preenchido!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void inicializarComponentes() {
        buttonAlterarAlteracaoProduto = (Button) this.findViewById(R.id.buttonDeletarProduto);
        buttonLimparAlteracaoProduto = (Button) this.findViewById(R.id.buttonLimparDeletarProduto);
        editTextCodigoAlteracaoProduto = (EditText) this.findViewById(R.id.editTextCodigoDeletarProduto);
        editTextNomeAlteracaoProduto = (EditText) this.findViewById(R.id.editTextNomeAlteracaoProduto);
        editTextDescricaoAlteracaoProduto = (EditText) this.findViewById(R.id.editTextDescricaoAlteracaoProduto);
        editTextEstoqueAlteracaoProduto = (EditText) this.findViewById(R.id.editTextEstoqueAlteracaoProduto);
    }

    private void voltarParaMenuPrincipal(){
        Intent intentMenuPrincipal = new Intent(this, MenuPrincipalActivityController.class);
        startActivity(intentMenuPrincipal);
    }
}
