package com.example.corresponsal.BD;

public class Constantes {

    public static final String TABLE_CORRESPONSAL = "t_corresponsal";
    public static final String TABLE_CLIENTE = "t_cliente";
    public static final String CREAR_CORRESPONSAL = "CREATE TABLE " + TABLE_CORRESPONSAL + "(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, NIT INTEGER, correoElectronico TEXT, contrasena TEXT)";
    public static final String INSERTAR_CORRESPONSAL = "INSERT INTO " + TABLE_CORRESPONSAL + "(nombre, NIT, correoElectronico, contrasena) VALUES ('Liseth Sandoval',455254, 'liseth@wposs.com', '123456')";
}
