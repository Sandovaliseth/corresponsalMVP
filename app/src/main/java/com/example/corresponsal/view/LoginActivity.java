package com.example.corresponsal.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.corresponsal.BD.BaseDatos;
import com.example.corresponsal.Interfaces.InterfaceCorresponsal;
import com.example.corresponsal.Presenter.PresentCorresponsal;
import com.example.corresponsal.R;
import com.example.corresponsal.entidades.Corresponsal;
import com.example.corresponsal.view.Admin.MainActivityAdmin;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity implements InterfaceCorresponsal.View, View.OnClickListener {

    ConstraintLayout interfazC, interfazB;
    TextInputEditText correoCorresponsal, contrasenaCorresponsal;
    Button iniciarSesion;
    InterfaceCorresponsal.Presenter presenterC;
    Corresponsal corresponsal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.variables();
        presenterC = new PresentCorresponsal(this, getApplicationContext());
        corresponsal = new Corresponsal();
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
        Intent intent = new Intent(getApplicationContext(), MainActivityAdmin.class);
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
                } else {
                    Toast.makeText(getApplicationContext(), "Ingrese el datos vacío", Toast.LENGTH_LONG
                    ).show();
                }
                break;
        }
    }
}