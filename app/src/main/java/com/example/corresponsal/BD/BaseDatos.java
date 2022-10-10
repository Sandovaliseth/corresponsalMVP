package com.example.corresponsal.BD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseDatos extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NOMBRE = "corresponsal.db";

    public BaseDatos (@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constantes.CREAR_CORRESPONSALPRINCIPAL);
        db.execSQL(Constantes.INSERTAR_CORRESPONSALPRINCIPAL);
        db.execSQL(Constantes.CREAR_BANCO);
        db.execSQL(Constantes.INSERTAR_BANCO);
        db.execSQL(Constantes.CREAR_CLIENTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE " + Constantes.TABLE_CORRESPONSAL);
        db.execSQL("DROP TABLE " + Constantes.TABLE_BANCO);
        db.execSQL("DROP TABLE " + Constantes.TABLE_CLIENTE);
        onCreate(db);
    }
}
