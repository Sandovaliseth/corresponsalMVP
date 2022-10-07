package com.example.corresponsal.view.Corresponsal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.corresponsal.R;
import com.example.corresponsal.view.ActualizarCorresponsalActivity;
import com.example.corresponsal.view.LoginActivity;

public class MainActivityC extends AppCompatActivity implements View.OnClickListener {

    Button menu, pagar, retiros, depositos, transferencias, historialT, consultarSaldo;
    TextView nombre, saldo, cuenta;
    SharedPreferences sharedPreferences;
    PopupMenu popupMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_corresponsal);

        sharedPreferences = getSharedPreferences("bd_shared", Context.MODE_PRIVATE);
        pagar = findViewById(R.id.btnPago);
        pagar.setOnClickListener(this);
        retiros = findViewById(R.id.btnRetiros);
        retiros.setOnClickListener(this);
        depositos = findViewById(R.id.btnDepositos);
        depositos.setOnClickListener(this);
        transferencias = findViewById(R.id.btnTransferencias);
        transferencias.setOnClickListener(this);
        historialT = findViewById(R.id.btnHistorial);
        historialT.setOnClickListener(this);
        consultarSaldo = findViewById(R.id.btnSaldo);
        consultarSaldo.setOnClickListener(this);
        nombre = findViewById(R.id.txtNombreC);
        saldo = findViewById(R.id.txtSaldo);
        cuenta = findViewById(R.id.txtCuenta);
    }

    public void mostrarMenu(View v) {
        menu = findViewById(R.id.menu2);
        popupMenu = new PopupMenu(this, menu);
        popupMenu.getMenuInflater().inflate(R.menu.menu_principal, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuActualizar:
                        startActivity(new Intent(getApplicationContext(), ActualizarCorresponsalActivity.class));
                        finish();
                        return true;
                    case R.id.menuNuevo:
                        startActivity(new Intent(getApplicationContext(), CrearClienteBankActivity.class));
                        finish();
                        return true;
                    case R.id.menuCerrar:
                        CerrarSesion();
                        return true;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    private void CerrarSesion(){
        sharedPreferences.edit().clear().apply();
        Toast.makeText(getApplicationContext(), "Sesion finalizada", Toast.LENGTH_LONG
        ).show();
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPago:
                startActivity(new Intent(getApplicationContext(), PagoActivity.class));
                finish();
                break;
            case R.id.btnRetiros:
                startActivity(new Intent(getApplicationContext(), RetirosActivity.class));
                finish();
                break;
            case R.id.btnDepositos:
                startActivity(new Intent(getApplicationContext(), RetirosActivity.class));
                finish();
                break;
            case R.id.btnTransferencias:
                startActivity(new Intent(getApplicationContext(), RetirosActivity.class));
                finish();
                break;
            case R.id.btnHistorial:
                startActivity(new Intent(getApplicationContext(), RetirosActivity.class));
                finish();
                break;
            case R.id.btnSaldo:
                startActivity(new Intent(getApplicationContext(), RetirosActivity.class));
                finish();
                break;
            default:
                break;
        }
    }
}