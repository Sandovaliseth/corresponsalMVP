package com.example.corresponsal.entidades;

public class Transferencia {

    private int cedulaClienteEmisor;
    private int pin;
    private int confirmarPin;
    private int cedulaClienteReceptor;
    private int monto;

    public int getCedulaClienteEmisor() {
        return cedulaClienteEmisor;
    }

    public void setCedulaClienteEmisor(int cedulaClienteEmisor) {
        this.cedulaClienteEmisor = cedulaClienteEmisor;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getConfirmarPin() {
        return confirmarPin;
    }

    public void setConfirmarPin(int confirmarPin) {
        this.confirmarPin = confirmarPin;
    }

    public int getCedulaClienteReceptor() {
        return cedulaClienteReceptor;
    }

    public void setCedulaClienteReceptor(int cedulaClienteReceptor) {
        this.cedulaClienteReceptor = cedulaClienteReceptor;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
}
