package com.example.corresponsal.Models;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.corresponsal.BD.BaseDatos;
import com.example.corresponsal.BD.Constantes;
import com.example.corresponsal.Interfaces.InterfacePago;
import com.example.corresponsal.entidades.Pago;

public class ModelPago extends BaseDatos implements InterfacePago.Model {

    InterfacePago.Presenter presenter;
    Context context;
    SQLiteDatabase db;
    public static final String TARJETANUMERO = "numeroTarjeta";
    public static final String FECHA = "fechaExpiracion";
    public static final String CVV = "CVV";
    public static final String CLIENTE = "nombreCliente";
    public static final String CUOTAS = "cuotas";
    public static final String PAGO = "valorPagar";

    public ModelPago(InterfacePago.Presenter presenter, Context context) {
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
    public long insertar(Pago pago) {
        long id=0;
        try{
            db= this.OpenConexionDb(context);
            ContentValues values = new ContentValues();
            values.put(TARJETANUMERO, pago.getNumeroTarjeta());
            values.put(FECHA, pago.getFechaExpiracion());
            values.put(CVV, pago.getCVV());
            values.put(CLIENTE, pago.getNombreCliente().getNombre());
            values.put(PAGO, pago.getValorPagar());
            values.put(CUOTAS, pago.getCuotas());
            id = db.insert(Constantes.TABLE_PAGOS, null, values);
        } catch (Exception ex){
            ex.toString();
        }
        return id;
    }
}
