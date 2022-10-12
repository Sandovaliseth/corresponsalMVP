package com.example.corresponsal.entidades;

public class Retiros {

    private int numeroCedula;
    private int pinCuenta;
    private int confirmarPinCuenta;
    private int monto;

    public Retiros() {
    }

    public int getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(int numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public int getPinCuenta() {
        return pinCuenta;
    }

    public void setPinCuenta(int pinCuenta) {
        this.pinCuenta = pinCuenta;
    }

    public int getConfirmarPinCuenta() {
        return confirmarPinCuenta;
    }

    public void setConfirmarPinCuenta(int confirmarPinCuenta) {
        this.confirmarPinCuenta = confirmarPinCuenta;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
}
