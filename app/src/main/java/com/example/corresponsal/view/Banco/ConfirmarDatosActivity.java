package com.example.corresponsal.view.Banco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.corresponsal.Interfaces.InterfaceCorresponsal;
import com.example.corresponsal.R;

public class ConfirmarDatosActivity extends AppCompatActivity implements View.OnClickListener {

    TextView nombreCorresponsal, cuenta, saldoCorresponsal, correoCorresponsal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);
    }

    @Override
    public void onClick(View view) {

    }
}