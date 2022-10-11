package com.example.corresponsal.Interfaces;

import com.example.corresponsal.entidades.Cliente;

import java.util.ArrayList;

public interface InterfaceCliente {

    interface View {
        void variables();
        long validarRegistro(long dato);
    }

    interface Presenter {
        void nuevoCliente(Cliente cliente);
        Cliente consultarCliente(Cliente cliente);
        ArrayList<Cliente> lista();
        void validacion(long dato);
    }

    interface Model {
        long insertarCliente(Cliente cliente);
        ArrayList<Cliente> mostrarClientes();
        Cliente consultarCliente(Cliente cliente);
    }
}
