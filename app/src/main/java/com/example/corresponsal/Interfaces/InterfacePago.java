package com.example.corresponsal.Interfaces;

import com.example.corresponsal.entidades.Cliente;
import com.example.corresponsal.entidades.Pago;

import java.util.ArrayList;

public interface InterfacePago {

    interface View {
        void variables();
        long validarRegistro(long dato);
    }

    interface Presenter {
        void pagoTarjeta(Cliente cliente);
        void validacion(long dato);
    }

    interface Model {
        long insertar(Pago pago);
    }
}
