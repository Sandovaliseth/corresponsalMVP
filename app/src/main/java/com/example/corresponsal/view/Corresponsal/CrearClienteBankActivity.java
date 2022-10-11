package com.example.corresponsal.view.Corresponsal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.corresponsal.Interfaces.InterfaceCliente;
import com.example.corresponsal.Presenter.PresentCliente;
import com.example.corresponsal.R;
import com.example.corresponsal.entidades.Cliente;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Locale;

public class CrearClienteBankActivity extends AppCompatActivity implements View.OnClickListener, InterfaceCliente.View {

    EditText nombre, cedula, pin, confirmarPin;
    TextInputEditText saldoInicial;
    Button confirmar, cancelar;
    Cliente cliente;
    InterfaceCliente.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cliente);

        this.variables();
        cliente = new Cliente();
        presenter = new PresentCliente(this, getApplicationContext());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnConfirmar2:
                cliente.setNombre(nombre.getText().toString());
                cliente.setDocumento(Integer.parseInt(cedula.getText().toString()));
                cliente.setPIN(Integer.parseInt(pin.getText().toString()));
                cliente.setConfirmarPIN(Integer.parseInt(confirmarPin.getText().toString()));
                cliente.setSaldo(Double.parseDouble(saldoInicial.getText().toString()));
                presenter.nuevoCliente(cliente);
                break;
            case R.id.btnCancelar2:

                break;
            default:
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