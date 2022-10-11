package com.example.corresponsal.Interfaces;

import com.example.corresponsal.entidades.Cliente;

public interface InterfaceCliente {

    interface View {
        void variables();
        long validarRegistro(long dato);
    }

    interface Presenter {
        void nuevoCliente(Cliente cliente);
        void consultarCliente(Cliente cliente);
        void listaClientes(Cliente cliente);
        void saldoCliente(Cliente cliente);
        void validacion(long dato);
    }

    interface Model {
        long insertarCliente(Cliente cliente);
        void consultar(Cliente cliente);
        void listado(Cliente cliente);
        void saldo(Cliente cliente);
    }
}
