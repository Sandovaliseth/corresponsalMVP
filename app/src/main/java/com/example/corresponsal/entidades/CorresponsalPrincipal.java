package com.example.corresponsal.entidades;

public class CorresponsalPrincipal {

    private int id;
    private String nombreCorresponsal;
    private double saldo;
    private int numeroCuenta;
    private String correoElectronico;
    private String contrasena;

    public CorresponsalPrincipal() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCorresponsal() {
        return nombreCorresponsal;
    }

    public void setNombreCorresponsal(String nombreCorresponsal) {
        this.nombreCorresponsal = nombreCorresponsal;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
