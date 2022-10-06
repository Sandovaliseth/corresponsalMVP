package com.example.corresponsal.entidades;

public class Cliente {

    private int id;
    private String nombre;
    private int documento;
    private int PIN;
    private int confirmarPIN;
    private double saldo;

    public Cliente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    public int getConfirmarPIN() {
        return confirmarPIN;
    }

    public void setConfirmarPIN(int confirmarPIN) {
        this.confirmarPIN = confirmarPIN;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
