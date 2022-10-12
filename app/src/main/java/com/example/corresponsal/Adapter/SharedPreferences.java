package com.example.corresponsal.Adapter;

import android.content.Context;

public class SharedPreferences {
    Context context;
    android.content.SharedPreferences.Editor editor;
    android.content.SharedPreferences sp;

    public SharedPreferences(Context context) {
        this.context = context;
        sp = context.getSharedPreferences("bd_shared", Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    public String getSharedPreferences() {
        return sp.getString("correoElectronico", "Dato no registrado");
    }

    public void setSharedPreferences(String correo, String nombreC, int NITC, Double saldoC) {
        editor.putString("correoElectronico", correo);
        editor.putString("nombre", nombreC);
        editor.putInt("NIT", NITC);
        editor.putLong("saldo", Double.doubleToLongBits(saldoC));
        editor.apply();
    }

    public void guardarSesion(Boolean checked) {
        editor.putBoolean("llave", checked);
        editor.apply();
    }

    public void guardarVariables(String nombreC, int NITC, Double saldoC) {
        editor.putString("variable1", nombreC);
        editor.putInt("variable2", NITC);
        editor.putLong("variable3", Double.doubleToLongBits(saldoC));
        editor.apply();
    }

    public boolean revisarSesion() {
        return this.sp.getBoolean("llave", false);
    }

    public String getSharedPreferencesBanco() {
        return sp.getString("correoE", "Dato no registrado");
    }

    public void setSharedPreferencesBanco(String correo) {
        editor.putString("correoE", correo);
        editor.apply();
    }

    public void guardarSesionBanco(Boolean checked) {
        editor.putBoolean("llave2", checked);
        editor.apply();
    }

    public boolean revisarSesionBanco() {
        return this.sp.getBoolean("llave2", false);
    }
}
