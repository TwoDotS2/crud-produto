package com.ufrn.imd.crud_produto.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ufrn.imd.crud_produto.R;
import com.ufrn.imd.crud_produto.dto.ProdutoDTO;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ProdutoDTOAdpter extends ArrayAdapter<ProdutoDTO> {
    public ProdutoDTOAdpter(@NonNull Context context, ArrayList<ProdutoDTO> produtos) {
        super(context, 0, produtos);
    }

    @NonNull
    @Override
    public View getView(int posicao, @Nullable View viewConverter, @NonNull ViewGroup pai) {
        View viewAtualNaLista = viewConverter;

        if (viewAtualNaLista == null) {
            viewAtualNaLista = LayoutInflater.from(getContext()).inflate(R.layout.list_view_item_produto, pai, false);
        }

        ProdutoDTO produtoNaPosicaoAtual = getItem(posicao);

        TextView textViewCodigoProduto = viewAtualNaLista.findViewById(R.id.textViewCodigoProduto);
        textViewCodigoProduto.setText(produtoNaPosicaoAtual.getCodigo());

        TextView textViewNomeProduto = viewAtualNaLista.findViewById(R.id.textViewNomeProduto);
        textViewNomeProduto.setText(produtoNaPosicaoAtual.getNome());

        TextView textViewDescricaoProduto = viewAtualNaLista.findViewById(R.id.textViewDescricaoProduto);
        textViewDescricaoProduto.setText(produtoNaPosicaoAtual.getDescricao());

        TextView textViewQuatidadeEstoqueProduto = viewAtualNaLista.findViewById(R.id.textViewQuantidadeEstoqueProduto);
        textViewQuatidadeEstoqueProduto.setText(produtoNaPosicaoAtual.getQuantidadeEstoque().toString());

        return viewAtualNaLista;
    }
}
