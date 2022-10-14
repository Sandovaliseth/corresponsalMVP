package com.example.corresponsal.view.Corresponsal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.corresponsal.Interfaces.InterfaceCliente;
import com.example.corresponsal.Presenter.PresentCliente;
import com.example.corresponsal.R;
import com.example.corresponsal.entidades.Cliente;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class PinConfirmarActivity extends AppCompatActivity implements View.OnClickListener, InterfaceCliente.View {

    Cliente cliente;
    InterfaceCliente.Presenter presenter;
    String nombre;
    Integer cedula, pin;
    Double saldo;
    EditText confirmarPin;
    Button aceptar, cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_confirmar);

        this.variables();
        cliente = new Cliente();
        presenter = new PresentCliente(this, getApplicationContext());
    }

    @Override
    public void variables() {
        confirmarPin = findViewById(R.id.txtPinConfirmar);
        aceptar = findViewById(R.id.btnAceptar);
        aceptar.setOnClickListener(this);
        cancelar = findViewById(R.id.btnCancelar3);
        cancelar.setOnClickListener(this);
        Bundle recibirDatos = getIntent().getExtras();
        nombre = recibirDatos.getString("nombre");
        cedula = recibirDatos.getInt("cedula");
        saldo = recibirDatos.getDouble("saldo");
        pin = recibirDatos.getInt("PIN");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAceptar:
                if(confirmarPin.equals(pin)){
                    cliente.setNombre(nombre);
                    cliente.setDocumento(Integer.parseInt(cedula.toString()));
                    cliente.setPIN(Integer.parseInt(pin.toString()));
                    cliente.setConfirmarPIN(Integer.parseInt(confirmarPin.getText().toString()));
                    cliente.setSaldo(Double.parseDouble(saldo.toString()));
                    Long dato = presenter.nuevoCliente(cliente);
                    validarRegistro(dato);
                } else {
                    confirmarPin.setError("El pin no coincide");
                }
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

    public long validarRegistro(long dato) {
        if(dato>0){
            new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Cliente agregado correctamente")
                    .setConfirmText("salir")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismissWithAnimation();
                            startActivity(new Intent(getApplicationContext(), MainActivityC.class));
                            finish();
                        }
                    })
                    .show();
        } else{
            Toast.makeText(getApplicationContext(), "Error al guardar registro", Toast.LENGTH_LONG
            ).show();
        }
        return dato;
    }
}