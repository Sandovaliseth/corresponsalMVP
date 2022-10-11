package com.example.corresponsal.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.corresponsal.Interfaces.InterfaceBanco;
import com.example.corresponsal.Interfaces.InterfaceCorresponsal;
import com.example.corresponsal.Presenter.PresentBanco;
import com.example.corresponsal.Presenter.PresentCorresponsal;
import com.example.corresponsal.R;
import com.example.corresponsal.entidades.Banco;
import com.example.corresponsal.entidades.CorresponsalPrincipal;
import com.example.corresponsal.Adapter.SharedPreferences;
import com.example.corresponsal.view.Banco.MainBActivity;
import com.example.corresponsal.view.Corresponsal.MainActivityC;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity implements InterfaceCorresponsal.View, InterfaceBanco.View, View.OnClickListener {

    ConstraintLayout interfazC, interfazB;
    TextInputEditText correoCorresponsal, contrasenaCorresponsal, correoBanco, contrasenaBanco;
    Button iniciarSesion, iniciarSesion2;
    InterfaceCorresponsal.Presenter presenterC;
    CorresponsalPrincipal corresponsal;
    SharedPreferences sharedPreference;
    InterfaceBanco.Presenter presenterB;
    Banco banco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.variables();
        presenterC = new PresentCorresponsal(this, getApplicationContext());
        corresponsal = new CorresponsalPrincipal();
        presenterB = new PresentBanco(this, getApplicationContext());
        banco = new Banco();

        sharedPreference= new SharedPreferences(getApplicationContext());
        if (sharedPreference.revisarSesion()){
            startActivity(new Intent(LoginActivity.this, MainActivityC.class));
            finish();
        } else if(sharedPreference.revisarSesionBanco()) {
            startActivity(new Intent(LoginActivity.this, MainBActivity.class));
            finish();
        }
    }

    public void interfazCorresponsal(View v){
        interfazC.setVisibility(View.VISIBLE);
        interfazB.setVisibility(View.INVISIBLE);
    }

    public void interfazBanco(View v){
        interfazC.setVisibility(View.INVISIBLE);
        interfazB.setVisibility(View.VISIBLE);
    }

    @Override
    public void variables() {
        interfazC = (ConstraintLayout) findViewById(R.id.intCorresponsal);
        interfazB = (ConstraintLayout) findViewById(R.id.intBanco);
        correoCorresponsal = findViewById(R.id.correoC);
        contrasenaCorresponsal = findViewById(R.id.contraC);
        correoBanco = findViewById(R.id.correoElectronico);
        contrasenaBanco = findViewById(R.id.contrasena);
        iniciarSesion = findViewById(R.id.btnIniciarC);
        iniciarSesion.setOnClickListener(this);
        iniciarSesion2 = findViewById(R.id.btnIniciar);
        iniciarSesion2.setOnClickListener(this);
    }

    @Override
    public void loginSucess() {
        Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_LONG
        ).show();
        Intent intent = new Intent(getApplicationContext(), MainActivityC.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void loginSucessB() {
        Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_LONG
        ).show();
        Intent intent = new Intent(getApplicationContext(), MainBActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void error() {
        Toast.makeText(getApplicationContext(), "Error de credenciales", Toast.LENGTH_LONG
        ).show();
    }

    public boolean vacioValidar(String dato) {
        return !dato.equals("");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnIniciarC:
                String email = correoCorresponsal.getText().toString(), contrasena = contrasenaCorresponsal.getText().toString();
                if (vacioValidar(email) & vacioValidar(contrasena)) {
                    corresponsal.setCorreoElectronico(email);
                    corresponsal.setContrasena(contrasena);
                    presenterC.Login(corresponsal);
                    sharedPreference.guardarSesion(iniciarSesion.isClickable());
                } else {
                    Toast.makeText(getApplicationContext(), "Ingrese el datos vacío", Toast.LENGTH_LONG
                    ).show();
                }
                break;
            case R.id.btnIniciar:
                String emailB = correoBanco.getText().toString(), contrasenaB = contrasenaBanco.getText().toString();
                if (vacioValidar(emailB) & vacioValidar(contrasenaB)) {
                    banco.setCorreoE(emailB);
                    banco.setContrasena(contrasenaB);
                    presenterB.Login(banco);
                    sharedPreference.guardarSesionBanco(iniciarSesion2.isClickable());
                } else {
                    Toast.makeText(getApplicationContext(), "Ingrese el datos vacío", Toast.LENGTH_LONG
                    ).show();
                }
                break;
        }
    }
}