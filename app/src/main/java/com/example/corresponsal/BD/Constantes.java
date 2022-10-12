package com.example.corresponsal.BD;

public class Constantes {

    public static final String TABLE_CORRESPONSAL = "t_corresponsal";
    public static final String TABLE_BANCO = "t_banco";
    public static final String TABLE_CLIENTE = "t_cliente";
    public static final String CREAR_CORRESPONSALPRINCIPAL = "CREATE TABLE " + TABLE_CORRESPONSAL + "(id INTEGER PRIMARY KEY AUTOINCREMENT, nombreCorresponsal TEXT, saldo INTEGER, numeroCuenta INTEGER, correoElectronico TEXT, contrasena TEXT)";
    public static final String INSERTAR_CORRESPONSALPRINCIPAL = "INSERT INTO " + TABLE_CORRESPONSAL + "(nombreCorresponsal, saldo, numeroCuenta, correoElectronico, contrasena) VALUES ('CorresponsalHola',10.000, 12694586,'liseth@wposs.com', '123456')";
    public static final String CREAR_BANCO = "CREATE TABLE " + TABLE_BANCO + "(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, correoElectronico TEXT, contrasena TEXT)";
    public static final String INSERTAR_BANCO = "INSERT INTO " + TABLE_BANCO + "(nombre, correoElectronico, contrasena) VALUES ('BancoHi','admin@wposs.com', 'Admin123*')";
    public static final String CREAR_CLIENTE = "CREATE TABLE " + TABLE_CLIENTE + "(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, documento INTEGER, PIN INTEGER, confirmarPIN INTEGER, saldo Double)";

    //Preferences
}
