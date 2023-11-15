package com.ufrn.imd.crud_produto.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ufrn.imd.crud_produto.R;

public class LoginActivityController extends AppCompatActivity {

    private EditText editTextLogin;
    private EditText editTextSenha;
    private Button buttonEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inicializarComponentes();

        SharedPreferences sharedPreferences =
                getSharedPreferences("MYPREFS", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("login","adminadmin");
        editor.apply();

        buttonEntrar.setOnClickListener( v -> {
            String senhaUsuario = editTextSenha.getText().toString();
            String loginUsuario = editTextLogin.getText().toString() + senhaUsuario;

            String usuarioExiste = sharedPreferences.getString("login", loginUsuario);

            if( !usuarioExiste.isEmpty() ){
                Intent myIntent = new Intent(LoginActivityController.this, MenuPrincipalActivityController.class);
                startActivity(myIntent);

            } else {
                Toast.makeText(getApplicationContext(), "Login ou Senha Inválido!", Toast.LENGTH_LONG).show();
            }
        });

    }

    void inicializarComponentes(){
        editTextLogin = (EditText) this.findViewById(R.id.editTextLogin);
        editTextSenha = (EditText) this.findViewById(R.id.editTextSenha);
        buttonEntrar = (Button) this.findViewById(R.id.buttonEntrar);
    }
}