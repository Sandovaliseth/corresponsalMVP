package com.example.corresponsal.Interfaces;

import com.example.corresponsal.entidades.Cliente;

public interface InterfaceCliente {

    interface View {
        void variables();
    }

    interface Presenter {
        void nuevoCliente(Cliente cliente);
        void consultarCliente(Cliente cliente);
        void listaClientes(Cliente cliente);
        void saldoCliente(Cliente cliente);
    }

    interface Model {
        long insertarCliente(Cliente cliente);
        void consultar(Cliente cliente);
        void listado(Cliente cliente);
        void saldo(Cliente cliente);
    }
}