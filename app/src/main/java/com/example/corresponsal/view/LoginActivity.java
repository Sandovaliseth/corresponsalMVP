package com.example.corresponsal.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.corresponsal.Interfaces.InterfaceCorresponsal;
import com.example.corresponsal.Presenter.PresentCorresponsal;
import com.example.corresponsal.R;
import com.example.corresponsal.entidades.Corresponsal;
import com.example.corresponsal.Adapter.SharedPreferences;
import com.example.corresponsal.view.Corresponsal.MainActivityC;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity implements InterfaceCorresponsal.View, View.OnClickListener {

    ConstraintLayout interfazC, interfazB;
    TextInputEditText correoCorresponsal, contrasenaCorresponsal;
    Button iniciarSesion;
    InterfaceCorresponsal.Presenter presenterC;
    Corresponsal corresponsal;
    SharedPreferences sharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.variables();
        presenterC = new PresentCorresponsal(this, getApplicationContext());
        corresponsal = new Corresponsal();

        sharedPreference= new SharedPreferences(getApplicationContext());

        if(sharedPreference.revisarSesion()) {
            Intent intent = new Intent(LoginActivity.this, MainActivityC.class);
            startActivity(intent);
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
        iniciarSesion = findViewById(R.id.btnIniciarC);
        iniciarSesion.setOnClickListener(this);
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
        }
    }
}