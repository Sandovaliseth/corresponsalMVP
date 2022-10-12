package com.example.corresponsal.entidades;

public class ConsultarSaldo {

    private int cedula;
    private int Pin;
    private int confirmarPin;

    public ConsultarSaldo() {
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getPin() {
        return Pin;
    }

    public void setPin(int pin) {
        Pin = pin;
    }

    public int getConfirmarPin() {
        return confirmarPin;
    }

    public void setConfirmarPin(int confirmarPin) {
        this.confirmarPin = confirmarPin;
    }
}
