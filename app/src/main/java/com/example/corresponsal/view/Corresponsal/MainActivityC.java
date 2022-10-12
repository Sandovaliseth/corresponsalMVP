package com.example.corresponsal.view.Corresponsal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.corresponsal.Interfaces.InterfaceCliente;
import com.example.corresponsal.R;
import com.example.corresponsal.view.ActualizarCorresponsalActivity;
import com.example.corresponsal.view.LoginActivity;

public class MainActivityC extends AppCompatActivity implements View.OnClickListener, InterfaceCliente.View {

    Button menu, pagar, retiros, depositos, transferencias, historialT, consultarSaldo;
    TextView txtnombre, txtsaldo, txtcuenta;
    SharedPreferences sharedPreferences;
    PopupMenu popupMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_corresponsal);

        this.variables();
        sharedPreferences = getSharedPreferences("bd_shared", Context.MODE_PRIVATE);
        txtnombre.setText(sharedPreferences.getString("nombre", "Dato no registrado"));
        txtsaldo.setText(sharedPreferences.getString("NIT", "Dato no registrado"));
        txtcuenta.setText(sharedPreferences.getString("saldo", "Dato no registrado"));
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
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivityC.this);
        builder.setMessage("¿Desea salir del tu app Corresponsal?")
                .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sharedPreferences.edit().clear().apply();
                        Toast.makeText(getApplicationContext(), "Sesion finalizada", Toast.LENGTH_LONG
                        ).show();
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        finish();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Accion cancelada", Toast.LENGTH_LONG
                        ).show();
                    }
                }).show();
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
                startActivity(new Intent(getApplicationContext(), DepositosActivity.class));
                finish();
                break;
            case R.id.btnTransferencias:
                startActivity(new Intent(getApplicationContext(), TransferenciasActivity.class));
                finish();
                break;
            case R.id.btnHistorial:
                startActivity(new Intent(getApplicationContext(), HistorialTransaccionalActivity.class));
                finish();
                break;
            case R.id.btnSaldo:
                startActivity(new Intent(getApplicationContext(), SaldoActivity.class));
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    public void variables() {
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
        txtnombre = findViewById(R.id.txtNombreC);
        txtsaldo = findViewById(R.id.txtSaldo);
        txtcuenta = findViewById(R.id.txtCuenta);
    }

    @Override
    public long validarRegistro(long dato) {
        return 0;
    }
}