package com.example.corresponsal.Presenter;

import android.content.Context;

import com.example.corresponsal.Interfaces.InterfaceCliente;
import com.example.corresponsal.Models.ModelCliente;
import com.example.corresponsal.entidades.Cliente;

import java.util.ArrayList;

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
        validacion(this.model.insertarCliente(cliente));
    }

    @Override
    public Cliente consultarCliente(Cliente cliente) {
        return this.model.consultarCliente(cliente);
    }

    @Override
    public ArrayList<Cliente> lista() {
        return this.model.mostrarClientes();
    }

    @Override
    public void validacion(long dato) {
        this.view.validarRegistro(dato);
    }
}
