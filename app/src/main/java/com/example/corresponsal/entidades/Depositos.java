package com.example.corresponsal.entidades;

public class Depositos {

    private int cedulaEmisor;
    private int cedulaReceptor;
    private double monto;

    public Depositos() {
    }

    public int getCedulaEmisor() {
        return cedulaEmisor;
    }

    public void setCedulaEmisor(int cedulaEmisor) {
        this.cedulaEmisor = cedulaEmisor;
    }

    public int getCedulaReceptor() {
        return cedulaReceptor;
    }

    public void setCedulaReceptor(int cedulaReceptor) {
        this.cedulaReceptor = cedulaReceptor;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
