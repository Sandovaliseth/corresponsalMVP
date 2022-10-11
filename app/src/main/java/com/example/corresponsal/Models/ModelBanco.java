package com.example.corresponsal.Models;

import static com.example.corresponsal.BD.Constantes.TABLE_BANCO;
import static com.example.corresponsal.BD.Constantes.TABLE_CORRESPONSAL;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.corresponsal.BD.BaseDatos;
import com.example.corresponsal.Interfaces.InterfaceBanco;
import com.example.corresponsal.entidades.Banco;

public class ModelBanco extends BaseDatos implements InterfaceBanco.Model {

    InterfaceBanco.Presenter presenter;
    Context context;
    SQLiteDatabase db;

    public ModelBanco(InterfaceBanco.Presenter presenter, Context context) {
        super(context);
        this.context = context;
        this.presenter = presenter;
    }

    public SQLiteDatabase OpenConexionDb (Context context) {
        BaseDatos dbDatos = new BaseDatos(context);
        SQLiteDatabase db = dbDatos.getWritableDatabase();
        this.context= context;
        return db;
    }

    @Override
    public boolean Iniciar(Banco banco) {
        db= this.OpenConexionDb(context);
        Cursor cursorU = db.rawQuery("SELECT * FROM " + TABLE_BANCO + " WHERE correoElectronico= '" + banco.getCorreoE() + "' AND contrasena= '" + banco.getContrasena()+"'", null);
        if (cursorU.getCount()>0) {
            return true;
        } else {
            return false;
        }
    }

}
