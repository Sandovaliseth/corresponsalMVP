package com.example.corresponsal.view.Banco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.corresponsal.Interfaces.InterfaceCorresponsal;
import com.example.corresponsal.R;
import com.example.corresponsal.view.Corresponsal.MainActivityC;
import com.example.corresponsal.view.Corresponsal.PinCoActivity;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class RegistrarCorresponsalActivity extends AppCompatActivity implements View.OnClickListener, InterfaceCorresponsal.View {

    EditText nombre, nit, correo, contrasena;
    Button confirmar, cancelar;
    Bundle enviarDatosCo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_corresponsal);

        this.variables();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnConfirmar2:
                enviarDatosCo = new Bundle();
                enviarDatosCo.putString("nombre", nombre.getText().toString());
                enviarDatosCo.putInt("NIT", Integer.parseInt(nit.getText().toString()));
                enviarDatosCo.putString("correo", correo.getText().toString());
                enviarDatosCo.putString("contrasena", contrasena.getText().toString());
                Intent intent = new Intent(getApplicationContext(), PinCoActivity.class);
                intent.putExtras(enviarDatosCo);
                startActivity(intent);
            case R.id.btnCancelar2:
                new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Registro de corresponsal cancelado")
                        .setConfirmText("Salir")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                                startActivity(new Intent(getApplicationContext(), MainBActivity.class));
                                finish();
                            }
                        })
                        .show();
                break;
        }

    }

    @Override
    public void variables() {
        nombre = findViewById(R.id.txtNombreCorresponsal);
        nit = findViewById(R.id.txtNitCorresponsal);
        correo = findViewById(R.id.txtCorreoCorresponsal);
        contrasena = findViewById(R.id.txtContrasenaC);
        confirmar = findViewById(R.id.btnConfirmar2);
        confirmar.setOnClickListener(this);
        cancelar = findViewById(R.id.btnCancelar2);
        cancelar.setOnClickListener(this);
    }

    @Override
    public void loginSucess() {

    }

    @Override
    public void error() {

    }
}