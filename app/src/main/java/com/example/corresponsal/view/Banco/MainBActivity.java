package com.example.corresponsal.view.Banco;

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

import com.example.corresponsal.Interfaces.InterfaceCorresponsal;
import com.example.corresponsal.R;
import com.example.corresponsal.view.ActualizarCorresponsalActivity;
import com.example.corresponsal.view.Corresponsal.CrearClienteBankActivity;
import com.example.corresponsal.view.Corresponsal.PagoActivity;
import com.example.corresponsal.view.LoginActivity;

public class MainBActivity extends AppCompatActivity implements View.OnClickListener, InterfaceCorresponsal.View {

    Button menu;
    SharedPreferences sharedPreferences;
    PopupMenu popupMenu;
    TextView nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_banco);

        sharedPreferences = getSharedPreferences("bd_shared", Context.MODE_PRIVATE);
        this.variables();
    }

    public void mostrarMenu(View v) {
        menu = findViewById(R.id.menuB);
        popupMenu = new PopupMenu(this, menu);
        popupMenu.getMenuInflater().inflate(R.menu.menu_banco, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nuevoCorresponsal:
                        startActivity(new Intent(getApplicationContext(), ActualizarCorresponsalActivity.class));
                        finish();
                        return true;
                    case R.id.nuevosClientes:
                        startActivity(new Intent(getApplicationContext(), CrearClienteBankActivity.class));
                        finish();
                        return true;
                    case R.id.cerrarSesionBanco:
                        CerrarSesion();
                        return true;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    private void CerrarSesion(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainBActivity.this);
        builder.setMessage("¿Desea salir del tu app Corresponsal?")
                .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getApplicationContext(), "Sesion finalizada", Toast.LENGTH_LONG
                            ).show();
                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                            finish();
                            sharedPreferences.edit().clear().apply();
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
        switch(v.getId()) {
            case R.id.btnCrearCli:
                startActivity(new Intent(getApplicationContext(), CrearClienteActivity.class));
                break;
            case R.id.btnCrearCo:
                startActivity(new Intent(getApplicationContext(), RegistrarCorresponsalActivity.class));
                break;
            case R.id.btnConsultarCli:
                    startActivity(new Intent(getApplicationContext(), ConsultarClienteActivity.class));
                break;
            case R.id.btnConsultarCo:
                startActivity(new Intent(getApplicationContext(), ConsultarCorresponsalActivity.class));
                break;
            case R.id.btnListaCli:
                startActivity(new Intent(getApplicationContext(), ListaClientesActivity.class));
                break;
            case R.id.btnListaCo:
                startActivity(new Intent(getApplicationContext(), ListaCorresponsalesActivity.class));
                break;
        }
    }

    @Override
    public void variables() {
        nombre = findViewById(R.id.txtNombreC);
    }

    @Override
    public void loginSucess() {

    }

    @Override
    public void error() {

    }
}