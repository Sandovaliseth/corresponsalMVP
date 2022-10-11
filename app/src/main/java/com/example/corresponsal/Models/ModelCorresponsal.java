package com.example.corresponsal.Models;

import static com.example.corresponsal.BD.Constantes.TABLE_CORRESPONSAL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.corresponsal.BD.BaseDatos;
import com.example.corresponsal.BD.Constantes;
import com.example.corresponsal.Interfaces.InterfaceCorresponsal;
import com.example.corresponsal.entidades.CorresponsalPrincipal;

import java.util.ArrayList;

public class ModelCorresponsal extends BaseDatos implements InterfaceCorresponsal.Model {

    public static final String NOMBRE = "nombreCorresponsal";
    public static final String NIT = "numeroCuenta";
    public static final String CORREO = "correoElectronico";
    public static final String CONTRASENA = "contrasena";
    public static final String SALDO = "saldo";
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
    public boolean Iniciar(CorresponsalPrincipal corresponsal) {
        db= this.OpenConexionDb(context);
        Cursor cursorU = db.rawQuery("SELECT * FROM " + TABLE_CORRESPONSAL + " WHERE correoElectronico= '" + corresponsal.getCorreoElectronico() + "' AND contrasena= '" + corresponsal.getContrasena()+"'", null);
        if (cursorU.getCount()>0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public long registrarCorresponsal(CorresponsalPrincipal corresponsal) {
        long id=0;
        try{
            db= this.OpenConexionDb(context);
            ContentValues values = new ContentValues();
            values.put(NOMBRE, corresponsal.getNombreCorresponsal());
            values.put(NIT, corresponsal.getNumeroCuenta());
            values.put(CORREO, corresponsal.getCorreoElectronico());
            values.put(CONTRASENA, corresponsal.getContrasena());
            id = db.insert(Constantes.TABLE_CLIENTE, null, values);
        } catch (Exception ex){
            ex.toString();
        }
        return id;
    }

    @Override
    public ArrayList<CorresponsalPrincipal> mostrarCorresponsal() {
        db= this.OpenConexionDb(context);
        ArrayList<CorresponsalPrincipal> listadoCorresponsal = new ArrayList<>();
        CorresponsalPrincipal corresponsal = null;
        Cursor cursorCorresponsal = null;
        cursorCorresponsal = db.rawQuery("SELECT * FROM " + TABLE_CORRESPONSAL, null);
        if(cursorCorresponsal.moveToFirst()){
            do{
                corresponsal = new CorresponsalPrincipal();
                corresponsal.setId(cursorCorresponsal.getInt(0));
                corresponsal.setNombreCorresponsal(cursorCorresponsal.getString(1));
                corresponsal.setNumeroCuenta(cursorCorresponsal.getInt(2));
                corresponsal.setCorreoElectronico(cursorCorresponsal.getString(3));
                corresponsal.setSaldo(cursorCorresponsal.getLong(3));
                listadoCorresponsal.add(corresponsal);
            } while (cursorCorresponsal.moveToNext());
        }
        cursorCorresponsal.close();
        return listadoCorresponsal;
    }

    @Override
    public CorresponsalPrincipal consultarCorresponsal(CorresponsalPrincipal corresponsal) {
        db= this.OpenConexionDb(context);
        CorresponsalPrincipal corresponsalP = null;
        Cursor cursorCorresponsal;
        cursorCorresponsal = db.rawQuery("SELECT * FROM " + TABLE_CORRESPONSAL + " WHERE id= " + corresponsal.getNumeroCuenta() + " LIMIT 1", null);
        if(cursorCorresponsal.moveToFirst()){
            corresponsalP = new CorresponsalPrincipal();
            corresponsalP.setNombreCorresponsal(cursorCorresponsal.getString(0));
            corresponsalP.setNumeroCuenta(cursorCorresponsal.getInt(1));
            corresponsalP.setCorreoElectronico(cursorCorresponsal.getString(2));
            corresponsalP.setSaldo(cursorCorresponsal.getLong(3));
        }
        cursorCorresponsal.close();
        return corresponsalP;
    }
}
