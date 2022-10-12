package com.example.corresponsal.view.Corresponsal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.corresponsal.Interfaces.InterfaceCliente;
import com.example.corresponsal.Presenter.PresentCliente;
import com.example.corresponsal.R;
import com.example.corresponsal.entidades.Cliente;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class PinCoActivity extends AppCompatActivity implements View.OnClickListener, InterfaceCliente.View {

    EditText pin;
    Button cancelar, aceptar;
    String nombre;
    Integer cedula;
    Double saldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_co);

        this.variables();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAceptar:
                Bundle enviarDatos = new Bundle();
                enviarDatos.putInt("PIN", Integer.parseInt(pin.getText().toString()));
                enviarDatos.putString("nombre", nombre);
                enviarDatos.putInt("cedula", cedula);
                enviarDatos.putDouble("saldo", saldo);
                Intent intent = new Intent(getApplicationContext(), PinConfirmarActivity.class);
                intent.putExtras(enviarDatos);
                startActivity(intent);
                break;
            case R.id.btnCancelar3:
                new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Registro cliente cancelado")
                        .setConfirmText("Salir")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                                startActivity(new Intent(getApplicationContext(), MainActivityC.class));
                                finish();
                            }
                        })
                        .show();
                break;
        }
    }

    @Override
    public void variables() {
        pin = findViewById(R.id.txtPin);
        aceptar = findViewById(R.id.btnAceptar);
        aceptar.setOnClickListener(this);
        cancelar = findViewById(R.id.btnCancelar3);
        cancelar.setOnClickListener(this);
        Bundle recibirDatos = getIntent().getExtras();
        nombre = recibirDatos.getString("nombre");
        cedula = recibirDatos.getInt("cedula");
        saldo = recibirDatos.getDouble("saldo");
    }

    @Override
    public long validarRegistro(long dato) {
        return 0;
    }
}