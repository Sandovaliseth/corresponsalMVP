package com.example.corresponsal.Interfaces;

import com.example.corresponsal.entidades.Cliente;

import java.util.ArrayList;

public interface InterfaceCliente {

    interface View {
        void variables();
    }

    interface Presenter {
        long nuevoCliente(Cliente cliente);
        Cliente consultarCliente(Cliente cliente);
        ArrayList<Cliente> lista();
    }

    interface Model {
        long insertarCliente(Cliente cliente);
        ArrayList<Cliente> mostrarClientes();
        Cliente consultarCliente(Cliente cliente);
    }
}
