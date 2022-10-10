package com.example.corresponsal.Models;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.corresponsal.BD.BaseDatos;
import com.example.corresponsal.BD.Constantes;
import com.example.corresponsal.Interfaces.InterfaceCliente;
import com.example.corresponsal.entidades.Cliente;

public class ModelCliente extends BaseDatos implements InterfaceCliente.Model {

    InterfaceCliente.Presenter presenter;
    Context context;
    SQLiteDatabase db;
    public static final String NOMBRE = "nombre";
    public static final String DOCUMENTO = "documento";
    public static final String PIN = "PIN";
    public static final String CONFPIN = "confirmarPIN";
    public static final String SALDO = "saldo";

    public ModelCliente(InterfaceCliente.Presenter presenter, Context context) {
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
    public long insertarCliente(Cliente cliente) {
        long id=0;
        try{
            db= this.OpenConexionDb(context);
            ContentValues values = new ContentValues();
            values.put(NOMBRE, cliente.getNombre());
            values.put(DOCUMENTO, cliente.getDocumento());
            values.put(PIN, cliente.getPIN());
            values.put(CONFPIN, cliente.getConfirmarPIN());
            values.put(SALDO, cliente.getSaldo());
            id = db.insert(Constantes.TABLE_CLIENTE, null, values);
        } catch (Exception ex){
            ex.toString();
        }
        return id;
    }

    @Override
    public void consultar(Cliente cliente) {

    }

    @Override
    public void listado(Cliente cliente) {

    }

    @Override
    public void saldo(Cliente cliente) {

    }
}
