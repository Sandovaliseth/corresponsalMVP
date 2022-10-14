package com.example.corresponsal.view.Corresponsal;

import static com.example.corresponsal.BD.MetodosAdicionales.validarMayusculas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.corresponsal.BD.MetodosAdicionales;
import com.example.corresponsal.Interfaces.InterfaceCliente;
import com.example.corresponsal.R;
import com.google.android.material.textfield.TextInputEditText;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class CrearClienteBankActivity extends AppCompatActivity implements View.OnClickListener, InterfaceCliente.View {

    EditText nombre, cedula, pin, confirmarPin;
    TextInputEditText saldoInicial;
    Button confirmar, cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cliente);

        this.variables();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnConfirmar2:
                if (MetodosAdicionales.vacioValidar(nombre.getText().toString()) & MetodosAdicionales.vacioValidar(cedula.getText().toString()) & MetodosAdicionales.vacioValidar(saldoInicial.getText().toString())) {
                    if (MetodosAdicionales.validarMayusculas(nombre.getText().toString())) {
                        Bundle enviarDatos = new Bundle();
                        enviarDatos.putString("nombre", nombre.getText().toString());
                        enviarDatos.putInt("cedula", Integer.parseInt(cedula.getText().toString()));
                        enviarDatos.putDouble("saldo", Double.parseDouble(saldoInicial.getText().toString()));
                        Intent intent = new Intent(getApplicationContext(), PinCoActivity.class);
                        intent.putExtras(enviarDatos);
                        startActivity(intent);
                    } else {
                        nombre.setError("El campo solo acepta mayusculas");
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Unos o más campos estan vacíos", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnCancelar2:
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
        nombre = findViewById(R.id.txtNombreCliente);
        cedula = findViewById(R.id.txtCedula);
        pin = findViewById(R.id.pin);
        confirmarPin = findViewById(R.id.confirmarPin);
        saldoInicial = findViewById(R.id.saldo);
        confirmar = findViewById(R.id.btnConfirmar2);
        confirmar.setOnClickListener(this);
        cancelar = findViewById(R.id.btnCancelar2);
        cancelar.setOnClickListener(this);
    }
}