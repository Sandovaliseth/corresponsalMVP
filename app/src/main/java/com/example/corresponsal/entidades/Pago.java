package com.example.corresponsal.entidades;

public class Pago {
    private int id;
    private int numeroTarjeta;
    private int fechaExpiracion;
    private int CVV;
    private Cliente nombreCliente;
    private int cuotas;
    private double valorPagar;

    public Pago() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(int fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public Cliente getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(Cliente nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }
}
