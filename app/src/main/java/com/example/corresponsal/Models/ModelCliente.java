package com.example.corresponsal.Models;

import static com.example.corresponsal.BD.Constantes.TABLE_BANCO;
import static com.example.corresponsal.BD.Constantes.TABLE_CLIENTE;
import static com.example.corresponsal.BD.Constantes.TABLE_CORRESPONSAL;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.corresponsal.BD.BaseDatos;
import com.example.corresponsal.BD.Constantes;
import com.example.corresponsal.Interfaces.InterfaceCliente;
import com.example.corresponsal.entidades.Banco;
import com.example.corresponsal.entidades.Cliente;
import com.example.corresponsal.entidades.CorresponsalPrincipal;
import com.example.corresponsal.view.Corresponsal.PinCoActivity;

import java.util.ArrayList;

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
    public ArrayList<Cliente> mostrarClientes() {
            db= this.OpenConexionDb(context);
            ArrayList<Cliente> listadoClientes = new ArrayList<>();
            Cliente cliente = null;
            Cursor cursorClientes = null;
            cursorClientes = db.rawQuery("SELECT * FROM " + TABLE_CLIENTE, null);
            if(cursorClientes.moveToFirst()){
                do{
                    cliente = new Cliente();
                    cliente.setId(cursorClientes.getInt(0));
                    cliente.setNombre(cursorClientes.getString(1));
                    cliente.setDocumento(cursorClientes.getInt(2));
                    cliente.setSaldo(cursorClientes.getLong(3));
                    listadoClientes.add(cliente);
                } while (cursorClientes.moveToNext());
            }
            cursorClientes.close();
            return listadoClientes;
    }

    @Override
    public Cliente consultarCliente(Cliente cliente) {
        db= this.OpenConexionDb(context);
        Cliente clienteConsulta = null;
        Cursor cursorCliente;
        cursorCliente = db.rawQuery("SELECT * FROM " + TABLE_CLIENTE + " WHERE id= " + cliente.getDocumento() + " LIMIT 1", null);
        if(cursorCliente.moveToFirst()){
            clienteConsulta = new Cliente();
            clienteConsulta.setNombre(cursorCliente.getString(0));
            clienteConsulta.setDocumento(cursorCliente.getInt(1));
            clienteConsulta.setSaldo(cursorCliente.getLong(2));
        }
        cursorCliente.close();
        return clienteConsulta;
    }
}
