package com.example.corresponsal.Models;

import static com.example.corresponsal.BD.Constantes.TABLE_CORRESPONSAL;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.corresponsal.BD.BaseDatos;
import com.example.corresponsal.Interfaces.InterfaceCorresponsal;
import com.example.corresponsal.entidades.Corresponsal;

public class ModelCorresponsal extends BaseDatos implements InterfaceCorresponsal.Model {

    InterfaceCorresponsal.Presenter presenter;
    Context context;
    SQLiteDatabase db;

    public ModelCorresponsal(InterfaceCorresponsal.Presenter presenter, Context context) {
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
    public boolean Iniciar(Corresponsal corresponsal) {
        db= this.OpenConexionDb(context);
        Cursor cursorU = db.rawQuery("SELECT * FROM " + TABLE_CORRESPONSAL + " WHERE correoElectronico= '" + corresponsal.getCorreoElectronico() + "' AND contrasena= '" + corresponsal.getContrasena()+"'", null);
        if (cursorU.getCount()>0) {
            return true;
        } else {
            return false;
        }
    }
}
