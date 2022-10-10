package com.example.corresponsal.Presenter;

import android.content.Context;

import com.example.corresponsal.Interfaces.InterfaceCliente;
import com.example.corresponsal.Models.ModelCliente;
import com.example.corresponsal.entidades.Cliente;

public class PresentCliente implements InterfaceCliente.Presenter {

    InterfaceCliente.View view;
    InterfaceCliente.Model model;
    Context context;

    public PresentCliente (InterfaceCliente.View view, Context context) {
        this.view = view;
        this.context = context;
        this.model = new ModelCliente(this, context);
    }

    @Override
    public void nuevoCliente(Cliente cliente) {
        this.model.insertarCliente(cliente);
    }

    @Override
    public void consultarCliente(Cliente cliente) {
        this.model.consultar(cliente);
    }

    @Override
    public void listaClientes(Cliente cliente) {
        this.model.listado(cliente);
    }

    @Override
    public void saldoCliente(Cliente cliente) {
        this.model.saldo(cliente);
    }
}
