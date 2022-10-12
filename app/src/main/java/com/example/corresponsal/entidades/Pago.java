package com.example.corresponsal.entidades;

public class Pago {
    private long numeroTarjeta;
    private int fechaExpiracion;
    private int CVV;
    private String nombreCliente;
    private int cuotas;
    private double valorPagar;

    public Pago() {
    }

    public long getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(long numeroTarjeta) {
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

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
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
