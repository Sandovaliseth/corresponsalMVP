package com.example.corresponsal.view.Corresponsal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.corresponsal.R;
import com.google.android.material.textfield.TextInputEditText;

public class PagoActivity extends AppCompatActivity {

    TextInputEditText numeroT, fecha, cvv, cliente, pago, cuotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago);

        numeroT = findViewById(R.id.numero);
        fecha = findViewById(R.id.fecha);
    }

    public void validarTrajeta(int dato) {
        if(dato<16){
            numeroT.setError("El numero de la tarjeta debe contener 16 dígitos");
        }
    }

    public void validarCVV(int dato) {
        if(dato>3){
            cvv.setError("El numero debe contener 3 caracteres");
        }
    }
}